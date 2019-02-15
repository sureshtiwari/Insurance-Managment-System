/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    : Userservices.java
           Principal Author             : Java_Th3_06
           Subsystem Name               : Training Project
           Module Name                  : User Module
           Date of First Release        : 20/01/2016
           Author                       : Java_Th3_06
           Description                  : used to fullfill all the requests of user
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3+06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.model.businesslogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.Payment;
import aricent.project.model.modelclasses.Policy;
import aricent.project.model.modelclasses.PolicyHolder;
import aricent.project.model.modelclasses.PolicySold;
/**
 *	Description about the class.
 *	@see UserServices
 *	@see Userservices#viewPolicyMatured
 *  @see Userservices#viewPolicyStatus
 *  @see Userservices#selectPolicyMode
 *  @see Userservices#changePolicyMode
 *  @see Userservices#viewAgents
 *  @see Userservices#viewPaymentDetails
 *  @see Userservices#calculatePayment
 *  @see Userservices#bupdatePayments
 *  @see Userservices#viewDetails
 *  @see Userservices#updateDeatils
 *	@version text
 *	@author Java_th3_06
 *    @since
 */

public class UserServices {
	 /**
	 *	Used to view all the policies maturing in 3 months
	 *  
	 *	@param name int userId
	 *    @exception HibernateException
	 *    @return List<List<Object>
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *   @since 14/02/2016
        **/

	public List<List<Object>> viewPolicyMatured(int userId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		Agent agent = new Agent();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query qry = session
					.createQuery(" from PolicySold P where P.userID=:E"); //load all the list taken by a particular agent
			qry.setParameter("E", userId);
			List<PolicySold> policySold = qry.list();
			for (PolicySold Ps : policySold) {

				Calendar c = Calendar.getInstance(); // get the current time
				c.setTime(Ps.getStartDate());
				c.add(Calendar.MONTH, Ps.getPremiumPaid());
				Long diff = ((c.getTimeInMillis()) - (Calendar.getInstance()
						.getTimeInMillis())) / (24 * 60 * 60 * 1000);// calculate diffeence
				if (diff > 0 && diff < 91) { //if difference <3 months then add details
					List<Object> list1 = new ArrayList<Object>();
					int agId = Ps.getAgentID();
					int PsId = Ps.getPolicyID();
					agent = (Agent) session.load(Agent.class, agId);
					policy = (Policy) session.load(Policy.class, PsId);
					list1.add(policy.getPolicyName());
					list1.add(policy.getPolicyType());
					list1.add(agent.getName());
					String[] sDate = (Ps.getStartDate().toString()).split("-");
					String startDate = sDate[2] + "/" + sDate[1] + "/"
							+ sDate[0];
					list1.add(startDate);
					list1.add(diff.toString());
					String[] eDate = (new Date(c.getTimeInMillis()).toString())
							.split("-");
					String endDate = eDate[2] + "/" + eDate[1] + "/" + eDate[0];
					list1.add(endDate);
					list.add(list1);
				}//end if
			}//end for

		}// end try 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
		return list;
	}
	 /**
		 *	Used to view the policy status
		 *  
		 *	@param name int userId
		 *    @exception HibernateException
		 *    @return List<List<Object>> 
		 *    @see UserServices
		 *	@version text
		 *	@author Java_th3_06
		 *    @since 14/02/2016
	        **/
	public List<List<Object>> viewPolicyStatus(int userId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		Agent agent = new Agent();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			int i;

			Query qry = session
					.createQuery(" from PolicySold P where P.userID=:E");// querry to find all the policies taken by the user
			qry.setParameter("E", userId);
			List<PolicySold> policySold = qry.list();

			for (PolicySold Ps : policySold) {
				List<Object> list1 = new ArrayList<Object>();

				int agentId = Ps.getAgentID();
				int PsId = Ps.getPolicyID();
				agent = (Agent) session.load(Agent.class, agentId);//load the agent details
				policy = (Policy) session.load(Policy.class, PsId);//load the policy details
				list1.add(policy.getPolicyName());
				list1.add(policy.getPolicyType());
				list1.add(agent.getName());

				i = Ps.getPaymentMode();
				if (i == 1)
					list1.add("Monthly");
				if (i == 3)
					list1.add("Quaterly");
				if (i == 6)
					list1.add("halfyearly");
				if (i == 12)
					list1.add("yearly");
				list1.add(policy.getDuration());
				list1.add(Ps.getNoOfPremium());
				list1.add(Ps.getStartDate().toString());
				list.add(list1);
			}//end for

		}//end for 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
		return list;
	}
	 /**
	 *	Used to select the Policy Mode
	 *  
	 *	@param name int userId
	 *    @exception HibernateException
	 *    @return List<List<Object>> 
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public List<List<Object>> selectPolicyMode(int userId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		Agent agent = new Agent();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query qry = session
					.createQuery(" from PolicySold P where P.userID=:E"); //load all the Policies taken by the user
			qry.setParameter("E", userId);
			List<PolicySold> policySold = qry.list();
			for (PolicySold Ps : policySold) {
				if (Ps.getPremiumPaid() != Ps.getNoOfPremium()) { // add the details only if all Premiums are not paid
					List<Object> list1 = new ArrayList<Object>();
					int agId = Ps.getAgentID();
					int PsId = Ps.getPolicyID();
					agent = (Agent) session.load(Agent.class, agId);
					policy = (Policy) session.load(Policy.class, PsId);
					list1.add(Ps.getTransactionID());
					list1.add(policy.getPolicyName());
					list1.add(policy.getPolicyType());
					list1.add(agent.getName());
					list1.add(Ps.getStartDate().toString());

					list1.add(Ps.getPremiumPaid());
					list1.add(Ps.getNoOfPremium());
					list1.add(Ps.getPaymentMode());
					list.add(list1);
				}//end if
			}//end for

		}//end for 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}
		return list;
	}
	 /**
		 *	Used to Change the Policy Mode
		 *  
		 *	@param name int userId
		 *    @exception HibernateException
		 *    @return int 
		 *    @see UserServices
		 *	@version text
		 *	@author Java_th3_06
		 *    @since 14/02/2016
	        **/
	public int changePolicyMode(int TransId, int changemode) {
		Session session = null;
		PolicySold psold = new PolicySold();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			psold = (PolicySold) session.get(PolicySold.class, TransId); //load the Policy detail
			psold.setPaymentMode(changemode);
			Transaction transaction = session.beginTransaction();
			session.update(psold);  //update  the Policy
			transaction.commit();

		}//end try 
		catch (Exception e) {

			return 0;
		}//end catch 
		finally {
			if (session != null) {
				session.close();
				return 1;
			}//end if
		}//endfinally
		return 1;
	}
	/**
	 *	Used to see the personal details
	 *  
	 *	@param name int userId
	 *    @exception HibernateException
	 *    @return List<Object>
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public List<Object> viewDetails(int PolicyHolderId) {
		String s[] = new String[3];
		Session session = null;
		List<Object> list = new ArrayList<Object>();
		PolicyHolder policyholderDetails;
		try {
			session = HibernateManager.getSessionFactory().openSession();
			policyholderDetails = (PolicyHolder) session.get(
					PolicyHolder.class, PolicyHolderId);//querry the details of the user
			list.add(policyholderDetails.getName()); 
			s[0] = ((Integer) policyholderDetails.getDob().getDate())
					.toString();
			s[1] = ((Integer) (policyholderDetails.getDob().getMonth() + 1))
					.toString();
			s[2] = ((Integer) (policyholderDetails.getDob().getYear() + 1900))
					.toString();
			System.out
					.println(((Integer) policyholderDetails.getDob().getDay())
							.toString());
			String date = s[0] + "/" + s[1] + "/" + s[2];
			list.add(date);
			list.add(policyholderDetails.getPhoneNumber());
			list.add(policyholderDetails.getEmail());
			list.add(policyholderDetails.getFathersName());
			String add[] = policyholderDetails.getAddress().split("@");
			list.add(add[0]);
			list.add(policyholderDetails.getCity());
			list.add(add[1]);
			list.add(add[2]);//add neccessry details

		}//end try
		finally 
		{
			if (session != null) {
				session.close();
			}//end if
		}//end finally

		return list;
	}
	/**
	 *	Used to all the agents from whom policy is taken
	 *  
	 *	@param name int userId
	 *    @exception HibernateException
	 *    @return List<Agent>
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public List<Agent> viewAgents(int userId) {
		Session session = null;
		List<Agent> list = new ArrayList<Agent>();

		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query qry = session
					.createQuery(" from PolicySold P where P.userID=:E");//querry to find all the detail of the policy of user
			qry.setParameter("E", userId);
			List<PolicySold> list1 = qry.list();
			for (PolicySold P : list1) {
				Agent agent = new Agent();
				agent = (Agent) session.get(Agent.class, P.getAgentID());//load the agent details
				list.add(agent);//add in list
			}//end for
		}//end try

		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
		return list;
	}
	/**
	 *	Used to see all Payments
	 *  
	 *	@param name int userId
	 *    @exception HibernateException
	 *    @return List<List<Object>>
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public List<List<Object>> viewPaymentDetails(int userId) {
		Session session = null;
		Session session1 = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		PolicySold Psold = new PolicySold();

		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			int i;

			Query qry = session
					.createQuery(" from PolicySold P where P.userID=:E");//Find all the Policies Taken by the user
			qry.setParameter("E", userId);
			List<PolicySold> policySold = qry.list();

			for (PolicySold Ps : policySold) {

				policy = (Policy) session.get(Policy.class, Ps.getPolicyID());
				Query qry1 = session
						.createQuery(" from Payment P where P.transaction_ID=:S");// find all the payments of the Policy
				qry1.setParameter("S", Ps.getTransactionID());

				List<Payment> payments = qry1.list();

				for (Payment pay1 : payments) {
					List<Object> list1 = new ArrayList<Object>();
					list1.add(policy.getPolicyName());
					list1.add(policy.getPolicyType());
					list1.add(pay1.getPayDate().toString());
					list1.add(pay1.getAmountPaid());

					list.add(list1);
				}//end for

			}//end for
			return list;

		}//end try
		finally {
			if (session != null) {
				session.close();
			}//end finally
		}
	}
	/**
	 *	Used to send details for calcullating payment
	 *  
	 *	@param name int userId
	 *    @exception HibernateException
	 *    @return List<List<Object>>
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public List<List<Object>> calculatePayment(int userId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		Agent agent = new Agent();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query qry = session
					.createQuery(" from PolicySold P where P.userID=:E");//querry all the policy taken by the user
			qry.setParameter("E", userId);
			List<PolicySold> policySold = qry.list();
			for (PolicySold Ps : policySold) {
				if (Ps.getPremiumPaid() != Ps.getNoOfPremium()) {// add details of the policy only if all premium are not paid
					List<Object> list1 = new ArrayList<Object>();
					int agId = Ps.getAgentID();
					int PsId = Ps.getPolicyID();
					agent = (Agent) session.load(Agent.class, agId);
					policy = (Policy) session.load(Policy.class, PsId);
					list1.add(Ps.getTransactionID());
					list1.add(policy.getPolicyName());
					list1.add(policy.getPolicyType());
					list1.add(agent.getName());
					list1.add(Ps.getStartDate().toString());

					list1.add(Ps.getPremiumPaid());
					list1.add(Ps.getNoOfPremium());
					list1.add(Ps.getPaymentMode());
					list1.add(policy.getTotalAmount());
					list.add(list1);
				}//end if
			}//end for

		} finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
		return list;
	}
	/**
	 *	Used to see the update the details of payment
	 *  
	 *	@param name int userId,int TransId
	 *    @exception HibernateException
	 *    @return List<Object>
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public int updatePayments(int TransId, int amount) {
		Session session = null;
		int usId;
		int Paymode;
		int TotalPremium;
		int amount1;

		try {
			Date d = new Date(Calendar.getInstance().getTimeInMillis()); //get the current time

			session = HibernateManager.getSessionFactory().openSession();
			PolicySold policySold = (PolicySold) session.load(PolicySold.class,
					TransId);//Load the Policy Sold
			Payment payment = new Payment();
			payment.setAmountPaid(amount);
			payment.setPayDate(d);
			payment.setTransaction_ID(TransId);
			usId = policySold.getUserID();
			Paymode = policySold.getPaymentMode();
			TotalPremium = policySold.getNoOfPremium();
			TotalPremium = TotalPremium + Paymode;//update total Premium Paid

			Transaction tx = session.beginTransaction();
			policySold.setNoOfPremium(TotalPremium);
			session.update(policySold);//Update The policySold table
			session.save(payment); //save Payment
			tx.commit();
			return 1;
		}//end try
		finally {

			if (session != null) {
				session.close();
			}//end finally
		}

	}
	/**
	 *	Used to update personal details
	 *  
	 *	@param name int userId, String name, String number,
			String address, String city, String state, String Zip
	 *    @exception HibernateException
	 *    @return int
	 *    @see UserServices
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
        **/
	public int updateDetails(int userId, String name, String number,
			String address, String city, String state, String Zip) {
		address = address + "@" + state + "@" + Zip;//append The address with Zip and state
		Session session = null;
		PolicyHolder pholder = new PolicyHolder();
		try {
			try {
				session = HibernateManager.getSessionFactory().openSession();
				pholder = (PolicyHolder) session
						.get(PolicyHolder.class, userId);
				pholder.setName(name);
				pholder.setPhoneNumber(Long.parseLong(number));
				pholder.setAddress(address);

				Transaction tx = session.beginTransaction();
				session.update(pholder);//update the details
				tx.commit();
			}//end try
			catch (Exception E) 
			{
				return -1;
			}//end catch

		}//end try
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finalyy

		return 1;
	}

}
