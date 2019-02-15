/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    :AdminServices.java
           Principal Author             : Java_Th3_06
           Subsystem Name               :Project
           Module Name                  :Admin Module
           Date of First Release        :20/01/2016
           Author                       :  Java_TH3_06
           Description                  :This class contains the bus
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3_06
           Description of change         : Initial Release
 
***********************************************************************/

package aricent.project.model.businesslogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import aricent.project.model.modelclasses.Admin;
import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.Payment;
import aricent.project.model.modelclasses.Policy;
import aricent.project.model.modelclasses.PolicyHolder;
import aricent.project.model.modelclasses.PolicySold;

/**
 * 
 *	Description about the class.
 *  
 *	@see 
 *	@see AdminServices#addaddNewAgent(String name, String fathersName, long phoneNumber,
			String email, String dob,addNewPolicy(String policyName, String policyType, int duration,
			int commission,adminLogin(String userName, String password), double totalAmount), String address, String city),viewPolicySoldDetails(),viewPaymentDetails(),viewAgentDetails(),viewPolicyHolderDetails()
 *	@version text
 *	@author java_TH3_06
 *
 */
public class AdminServices {

	Random R = new Random();
    /**
     * 
     *	Description about the Method.
     *  
     *	@param String name, String fathersName, long phoneNumber,
			String email, String dob, String address, String city
     *  @return Integer
     *  @see AdminServices
     *	@version text
     *	@author Java_TH3_06
     */
	public int addNewAgent(String name, String fathersName, long phoneNumber,
			String email, String dob, String address, String city) {
		Session session = null;
		try {
			session = HibernateManager.getSessionFactory().openSession();
			System.out.println(dob);
			Date date = Date.valueOf(dob);
			Agent P = new Agent();
			P.setPhoneNumber(phoneNumber);
			P.setAddress(address);
			P.setCity(city);
			P.setDob(date);
			int num = R.nextInt(99999) + 100000;
			P.setEmail(email);
			P.setFathersName(fathersName);
			P.setPassword(String.valueOf(num));
			P.setName(name);
			try {
				Transaction tx = session.beginTransaction();

				session.save(P);

				tx.commit();
				return 1;
			}//end of try 
			catch (Exception E) {
				E.printStackTrace();
				return -1;
			}//end of catch block 

		} //end of try
		catch (Exception E) {
			E.printStackTrace();
			return -1;
		} //end of catch
		finally {
			if (session != null) {
				session.close();
			}//end of if block
		}//end of finally block
	}//end of method

	/**
	 * 
	 *	Description about the Method.
	 *    @return List<List<Object>>
	 *    @see AdminServices
	 *	@version text
	 *	@author Java_TH3_06
	 */
	public List<List<Object>> viewPaymentDetails() {
		List<List<Object>> paylist = new ArrayList<List<Object>>();
		Session session = null;
		PolicySold policysold = new PolicySold();
		PolicyHolder policyholder = new PolicyHolder();
		Policy policy = new Policy();
		Agent agent = new Agent();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			try {
				Query qry = session.createQuery(" from Payment P ");
				List<Payment> l = qry.list();
				for (Payment Ps : l) {
					List<Object> list = new ArrayList<Object>();
					int transId = Ps.getTransaction_ID();
					policysold = (PolicySold) session.load(PolicySold.class,
							transId);
					policyholder = (PolicyHolder) session.load(
							PolicyHolder.class, policysold.getUserID());
					agent = (Agent) session.load(Agent.class,
							policysold.getAgentID());
					policy = (Policy) session.load(Policy.class,
							policysold.getPolicyID());
					list.add(policyholder.getName());
					list.add(agent.getName());
					list.add(policy.getPolicyName());
					list.add(Ps.getAmountPaid());
					String[] date = Ps.getPayDate().toString().split("-");
					list.add(date[2] + "/" + date[1] + "/" + date[0]);
					paylist.add(list);
				}// end of for loop

			}//end of try block 
			catch (Exception e) {
				System.out.println("hello");

			}//end of try block
		}//end of try block 
		finally 
		{
			if (session != null) {
				session.close();
			}// end of if block

		}// end of finally
		return paylist;

	}//end of method

	/**
	 * 
	 *	Description about the Method.
	 *    @exception name description
	 *    @return description
	 *    @see AdminServices
	 *    @deprecated
	 *	@version text
	 *	@author Java_TH3_06
	 *    @since
	 */
	public List<Agent> viewAgentDetails() {
		Session session = null;
		List<Agent> list = new ArrayList<Agent>();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			Query qry = session.createQuery("from Agent A");
			list = qry.list();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public List<PolicyHolder> viewPolicyHolderDetails() {
		Session session = null;
		List<PolicyHolder> list = new ArrayList<PolicyHolder>();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			Query qry = session.createQuery("from PolicyHolder B");
			list = qry.list();
		} finally {
			if (session != null)
				session.close();
		}
		return list;

	}

	public List<PolicySold> viewPolicySoldDetails() {
		Session session = null;
		List<PolicySold> list = new ArrayList<PolicySold>();
		PolicySold policysold = new PolicySold();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query qry = session.createQuery(" from PolicySold P");
			list = qry.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public int addNewPolicy(String policyName, String policyType, int duration,
			int commission, double totalAmount) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateManager.getSessionFactory().openSession();
			Policy P = new Policy();
			P.setPolicyName(policyName);
			P.setPolicyType(policyType);
			P.setDuration(duration);
			P.setCommission(commission);
			P.setTotalAmount(totalAmount);
			try {
				Transaction tx = session.beginTransaction();

				session.save(P);

				tx.commit();
				return 1;
			} catch (Exception E) {
				E.printStackTrace();
				return -1;
			}

		} catch (Exception E) {
			E.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Admin adminLogin(String userName, String password) {
		Session session = null;

		try {
			session = HibernateManager.getSessionFactory().openSession();
			Query qry = session
					.createQuery(" from Admin A where A.userName=:E ");
			qry.setParameter("E", userName);
			List<Admin> list = qry.list();
			Iterator<Admin> iterator = list.iterator();
			System.out.println(list.size());
			if (list.size() == 1) {
				Admin admin = iterator.next();
				System.out.println(admin.getUserName());
				if (admin.getPassword().equals(password)) {
					System.out.println(admin.getPassword());
					return admin;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();

		}
		return null;
	}
}
