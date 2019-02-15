/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    : AgentServices.java
           Principal Author             : Java_Th3_06
           Subsystem Name               : Project
           Module Name                  : Agent Module
           Date of First Release        :14/02/2016
           Author                       :  Java_Th3_06
           Description                  : This class consists of functions which
           fulfill the requests of agent  
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3_06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.model.businesslogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.Payment;
import aricent.project.model.modelclasses.Policy;
import aricent.project.model.modelclasses.PolicyHolder;
import aricent.project.model.modelclasses.PolicySold;
/**
 *	Description :This class consists of functions which
           fulfill the requests of agent 
 *  
 *	@see AgentServices
 *	@see AgentServices#checkUserAvailability
 *  @see AgentServices#addNewPolicyHolder
 *  @see AgentServices#viewPolicy
 *  @see AgentServices#viewPolicyHolder
 *  @see AgentServices#addPayment
 *  @see AgentServices#viewPolicyHolder
 *  @see AgentServices#addPayment
 *  @see AgentServices#viewCommission
 *  @see AgentServices#viewPolicyHolders
 *  @see AgentServices#viewDetails
 *  @see AgentServices#updateDetails
 *	@version text
 *	@author Java_TH3__06
 *    @since
 */

public class AgentServices {
	Random random = new Random();

	@SuppressWarnings("finally")
	 /**
	 *	Description used to find whether with a user exists in system or not
	 *	@param  String email 
	 *    @exception HbernateException
	 *    @return PolicyHolder Object
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since
**/
	public PolicyHolder checkUserAvailability(String email) {
		Session session = null;
		try {
			session = HibernateManager.getSessionFactory().openSession(); //get the session object
			Query query = session
					.createQuery(" from PolicyHolder A where A.email=:E "); //create the querry for searching a email in database
			query.setParameter("E", email);
			List<PolicyHolder> list = query.list();
			Iterator<PolicyHolder> iterator = list.iterator();
			if (list.size() == 1) {         //if present return the policy holder
				PolicyHolder agentHolder = (PolicyHolder) iterator.next();
				return agentHolder;
			}//end of if
		}//end of try 
		catch (HibernateException e) {
			e.printStackTrace();
		}//end of catch 
		finally {
			if(session!=null)
			session.close();
		}// end of finally
		return null; //if not return null

	}//end of function
	/**
	 *	Description used add new PolicyHoder
	 *	@param  int agentId, String name,String state, String zip, 
	 *int paymode, int policyId,
	 String fathersName, long phoneNumber, String email, Date dob,
			String address, String city
	 *    @exception HbernateException
	 *    @return PolicyHolder Object
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public PolicyHolder addNewPolicyHolder(int agentId, String name,
			String state, String zip, int paymode, int policyId,
			String fathersName, long phoneNumber, String email, Date dob,
			String address, String city) {
		Session session = null;
		try {
			session = HibernateManager.getSessionFactory().openSession();//get the session object from Hibernate Manager 
			PolicyHolder policyHolder = new PolicyHolder();
			policyHolder.setPhoneNumber(phoneNumber);
			address = address + "@" + state + "@" + zip;//apend the zip and state to address
			policyHolder.setAddress(address);
			policyHolder.setCity(city);
			policyHolder.setDob(dob);
			int num = random.nextInt(99999) + 100000;//randomly generate 6 digit password
			policyHolder.setEmail(email);
			policyHolder.setFathersName(fathersName);
			policyHolder.setPassword(String.valueOf(num));
			policyHolder.setFirstLogin(0);
			policyHolder.setName(name);
			System.out.println("Mail sent Registration Id is "+ num);
			//MailingSystem mailingSystem=new MailingSystem();
			//mailingSystem.sendMailViaSSL(email, "Registration Information", "Your Registration Id is "+String.valueOf(num));
			Transaction transaction = session.beginTransaction();//begin transaction
			Query query = session
					.createQuery(" from PolicyHolder A where A.email=:E ");
			query.setParameter("E", email);
			List<PolicyHolder> list = query.list();
			Iterator<PolicyHolder> iterator = list.iterator();
			if (list.size() == 1) {

				PolicyHolder agentHolder = (PolicyHolder) iterator.next();
				return agentHolder;
			}//end of if
			session.save(policyHolder);//save the policy holder
			transaction.commit(); // commit the transaction
			query = session
					.createQuery(" from PolicyHolder A where A.email=:E ");
			query.setParameter("E", email); //find the userId
			list = query.list();
			iterator = list.iterator();
			policyHolder = iterator.next();
			addPolicySold(policyHolder.getUserID(), policyId, paymode, agentId); //add the policy
		}//end try 
		catch (Exception e) {
			e.printStackTrace();
		}//end catch

		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
		return null;
	}
	/**
	 *	Description used to view all Policies in the sysytem
	 *	@param  void
	 *    @exception HbernateException
	 *    @return List of Policy Object
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/

	public List<Policy> viewPolicy() {

		Session session = null;

		try {
			session = HibernateManager.getSessionFactory().openSession();
			try {
				Query query = session.createQuery(" from Policy P ");//to fetch all the policy
				List<Policy> list = new ArrayList<Policy>();
				list = query.list();

				return list;

			}//end try 
			catch (Exception e) {
				return null;

			}//end catch
		}//end try 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally

	}
	/**
	 *	Description used to view all Policy holder in the syytem
	 *	@param  void
	 *    @exception HbernateException
	 *    @return List of Policy holder Object
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public List<PolicyHolder> viewPolicyHolder() {
		Session session = null;

		try {
			session = HibernateManager.getSessionFactory().openSession();
			try {
				Query query = session.createQuery(" from PolicyHolder P ");//to find all the policy holders
				List<PolicyHolder> list = new ArrayList<PolicyHolder>();
				list = query.list();
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					PolicyHolder policyHolder = (PolicyHolder) (iterator.next());
					System.out.println(policyHolder);
				}//end of while
				return list;

			}//end of try 
			catch (Exception e) {
				return null;

			}//end of catch
		}//end of try 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally

	}
	/**
	 *	Description used to add the first PAyment
	 *	@param  int amount, int TotalDuration,
			int Paymode, Date date
	 *    @exception HbernateException
	 *    @return void
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public synchronized void addPayment(int amount, int TotalDuration,
			int Paymode, Date date) {
		Session session = null;

		try {
			session = HibernateManager.getSessionFactory().openSession();
			int transactionId;
			Query query = session.createQuery(" from PolicySold P ");
			List<PolicySold> policySold = query.list();
			Collections.sort(policySold);
			Iterator iterator = policySold.iterator();
			transactionId = ((PolicySold) iterator.next()).getTransactionID();//find the transaction Id
			Payment payment = new Payment();
			payment.setAmountPaid(amount / (TotalDuration / Paymode));//calculate amount
			payment.setTransaction_ID(transactionId);
			payment.setPayDate(date);
			Transaction tx = session.beginTransaction();//save the payment
			session.save(payment);
			tx.commit();
		}//end of try 
		catch (Exception e) {
			e.printStackTrace();

		}//end of catch 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
	}
	/**
	 *	Description used to add the details of Policy Sold
	 *	@param  int userId, int PolicyId,
			int Paymode, int agentId
	 *    @exception HbernateException
	 *    @return integer
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public synchronized int addPolicySold(int userId, int PolicyId,
			int Paymode, int agentId) {
		Session session = null;

		try {

			session = HibernateManager.getSessionFactory().openSession();

			Policy policy = new Policy();
			policy = (Policy) session.load(Policy.class, PolicyId);

			int amount = (int) (policy.getTotalAmount());
			int TotalDuration = policy.getDuration();
			Date date = new Date(Calendar.getInstance().getTimeInMillis());// get the current date
			PolicySold policySold = new PolicySold();
			policySold.setAgentID(agentId);
			policySold.setPaymentMode(Paymode);
			policySold.setStartDate(date);
			policySold.setUserID(userId);
			policySold.setNoOfPremium(Paymode);
			policySold.setPremiumPaid(TotalDuration);
			policySold.setPolicyID(PolicyId);

			Transaction transaction = session.beginTransaction();

			System.out.println(date);

			session.save(policySold);//save the policysold

			transaction.commit();

			addPayment(amount, TotalDuration, Paymode, date);//add first payment
			return 1;
		}//end try 
		catch (Exception e) {
			e.printStackTrace();
		}//end catch 
		finally {
			if (session != null) {
				session.close();
			}//end finally
		}//end finally
		return 0;

	}
	/**
	 *	Description used to view all the Commision of Particular agent
	 *	@param   int agentId
	 *    @exception HbernateException
	 *    @return List<List<Object>>
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/

	public List<List<Object>> viewCommission(int agentId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		PolicyHolder pholder = new PolicyHolder();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();


			Query query = session
					.createQuery(" from PolicySold P where P.agentID=:E");// find all policy sold by the agent
			query.setParameter("E", agentId);
			List<PolicySold> policySold = query.list();

			for (PolicySold Ps : policySold) {
				List<Object> list1 = new ArrayList<Object>();
				int usId = Ps.getUserID();
				int PsId = Ps.getPolicyID();
				pholder = (PolicyHolder) session.load(PolicyHolder.class, usId);//load policy detail
				policy = (Policy) session.load(Policy.class, PsId);//load user detail
				list1.add(policy.getPolicyName());
				list1.add(pholder.getName());
				list1.add(Ps.getStartDate().toString());
				list1.add((Integer) policy.getCommission());
				list.add(list1);
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
	 *	Description used to view all the PolicySold Particular agent
	 *	@param   int agentId
	 *    @exception HbernateException
	 *    @return List<List<Object>>
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public List<List<Object>> viewPolicySold(int agentId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		PolicyHolder policyHolder = new PolicyHolder();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();
			int i;

			Query query = session
					.createQuery(" from PolicySold P where P.agentID=:E");//find policy sold by the agent
			query.setParameter("E", agentId);
			List<PolicySold> policySold = query.list();

			for (PolicySold policySold1 : policySold) {
				List<Object> list1 = new ArrayList<Object>();

				int userId = policySold1.getUserID();//load the user
				int PolicyId = policySold1.getPolicyID();//load policy information
				policyHolder = (PolicyHolder) session.load(PolicyHolder.class,
						userId);
				policy = (Policy) session.load(Policy.class, PolicyId);
				list1.add(policy.getPolicyName());
				list1.add(policy.getPolicyType());
				list1.add(policyHolder.getName());
				list1.add(policySold1.getStartDate().toString());
				i = policySold1.getPaymentMode();
				if (i == 1)
					list1.add("Monthly");
				if (i == 3)
					list1.add("Quaterly");
				if (i == 6)
					list1.add("HalfYearly");
				if (i == 12)
					list1.add("Yearly");
				list1.add(policy.getDuration());
				list1.add(policySold1.getNoOfPremium());
				list.add(list1);//add all detail
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
	 *	Description used to view all the Policy maturing in next 3 months by aParticular agent
	 *	@param   int agentId
	 *    @exception HbernateException
	 *    @return List<List<Object>>
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public List<List<Object>> viewPolicyMatured(int agentId) {
		Session session = null;
		List<List<Object>> list = new ArrayList<List<Object>>();

		PolicyHolder policyHolder = new PolicyHolder();
		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query query = session
					.createQuery(" from PolicySold P where P.agentID=:E");//find the policy sold by particular agent
			query.setParameter("E", agentId);
			List<PolicySold> policySold = query.list();
			for (PolicySold policyHolder1 : policySold) {

				Calendar calender = Calendar.getInstance();
				calender.setTime(policyHolder1.getStartDate());//get the start date
				calender.add(Calendar.MONTH, policyHolder1.getPremiumPaid());
				Long difference = ((calender.getTimeInMillis()) - (Calendar
						.getInstance().getTimeInMillis()))
						/ (24 * 60 * 60 * 1000);// calculate difference from current date
				if (difference > 0 && difference <= 90) {// if differnce is less than 3 months
					List<Object> list1 = new ArrayList<Object>();
					int userId = policyHolder1.getUserID();
					int policyId = policyHolder1.getPolicyID();
					policyHolder = (PolicyHolder) session.load(
							PolicyHolder.class, userId);//load the policy holder detail
					policy = (Policy) session.load(Policy.class, policyId);//load the policy detail
					list1.add(policy.getPolicyName());
					list1.add(policy.getPolicyType());
					list1.add(policyHolder.getName());
					list1.add(policyHolder1.getStartDate().toString());
					list1.add(difference.toString());
					list1.add((new Date(calender.getTimeInMillis()).toString()));
					list.add(list1);
				}//end if
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
	 *	Description used to view all the Policy Holder of a Particular agent
	 *	@param   int agentId
	 *    @exception HbernateException
	 *    @return List<PolicyHolder> 
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public List<PolicyHolder> viewPolicyHoders(int agentId) {
		Session session = null;
		List<PolicyHolder> list = new ArrayList<PolicyHolder>();

		Policy policy = new Policy();
		try {
			session = HibernateManager.getSessionFactory().openSession();

			Query query = session
					.createQuery(" from PolicySold P where P.agentID=:E");//load the policy sold by the agent
			query.setParameter("E", agentId);
			List<PolicySold> list1 = query.list();
			for (PolicySold policySold : list1) {
				PolicyHolder policyHolder = new PolicyHolder();
				policyHolder = (PolicyHolder) session.get(PolicyHolder.class,
						policySold.getUserID()); //load the policy holder detail
				list.add(policyHolder);
			}//end for
		}//end try

		finally {
			if (session != null) {
				session.close();
			}//end finally
		}//end finally
		return list;
	}
	/**
	 *	Description used to view details of a Particular agent
	 *	@param   int agentId
	 *    @exception HbernateException
	 *    @return List<Object>
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/

	public List<Object> viewDetails(int agentId) {
		String s[] = new String[3];
		Session session = null;
		List<Object> list = new ArrayList<Object>();
		Agent agentdetails;
		try {
			session = HibernateManager.getSessionFactory().openSession();
			agentdetails = (Agent) session.load(Agent.class, agentId);//laod the agent
			System.out.println(agentdetails.getName());
			list.add(agentdetails.getName());
			s[0] = ((Integer) agentdetails.getDob().getDate()).toString();
			s[1] = ((Integer) (agentdetails.getDob().getMonth() + 1))
					.toString();
			s[2] = ((Integer) (agentdetails.getDob().getYear() + 1900))
					.toString();
			System.out.println(((Integer) agentdetails.getDob().getDay())
					.toString());
			String date = s[0] + "/" + s[1] + "/" + s[2];
			String add[] = agentdetails.getAddress().split("@");//split the address into zip and state
			int size = add.length;
			String Address = add[0];
			String state = add[1];
			int Zip = Integer.parseInt(add[2]);
			list.add(date);
			list.add(agentdetails.getPhoneNumber());
			list.add(agentdetails.getEmail());
			list.add(agentdetails.getFathersName());
			list.add(Address);
			list.add(agentdetails.getCity());
			list.add(state);
			list.add(Zip);//add all detail to list

		}//end try 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}// finally

		return list;
	}
	/**
	 *	Description used to update details of a Particular agent
	 *	@param   int agentId
	 *    @exception HbernateException
	 *    @return integer
	 *    @see AgentServices
	 *	@version text
	 *	@author JAVA-th3_06
	 *    @since 14/02/2016
**/
	public int updateDetails(int agentId, String name, String number,
			String address, String city, String state, String Zip) {
		address = address + "@" + state + "@" + Zip;
		Session session = null;
		Agent agent = new Agent();
		try {
			try {
				session = HibernateManager.getSessionFactory().openSession();
				agent = (Agent) session.get(Agent.class, agentId);
				agent.setName(name);
				agent.setPhoneNumber(Long.parseLong(number));
				agent.setAddress(address);

				Transaction transaction = session.beginTransaction();
				session.update(agent);//save the updated information
				transaction.commit();
				return 1;
			}//end try 
			catch (Exception E) {
				return -1;
			}//end catch

		}//end try 
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally

	}
}
