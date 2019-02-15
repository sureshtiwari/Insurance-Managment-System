/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    :Authenticator.java
           Principal Author             : Java_Th3_06
           Subsystem Name               :Project
           Module Name                  :Authenticator Module
           Date of First Release        :20/01/2016
           Author                       :  Java_TH3_06
           Description                  :This class contains the login activity and
           change password
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3_06
           Description of change         : Initial Release
 
***********************************************************************/

package aricent.project.model.businesslogic;
/**
 *	Description about the class.
 *	@see Authenticator
 *	@see Authenticator#login
 *  @see Authenticator#changepassword
 *  @see Authenticator#fetchPassword
 *  @see Authenticator#forgetPassword
 *	@version text
 *	@author Java_Th3_06
 *  @since 20/02/2016
 */
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.PolicyHolder;

public class Authenticator {
	private int firstLogin;
	private int id;
	private String type;
	private String userName;
	private String password;
	/* ======================================================= * 
	            Constructors
	* ======================================================= */ 
	public  Authenticator(String email)
	{
		this.userName=email;
	}

	public Authenticator(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public Authenticator(int id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
	}

	public Authenticator(String type, String userName) {
		super();
		this.type = type;
		this.userName = userName;
	}

	public Authenticator(String type, String userName, String password) {
		super();
		this.type = type;
		this.userName = userName;
		this.password = password;
	}
	/* ======================================================= * 
	ACCESSOR METHODS  
	* ======================================================= */ 

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(int firstLogin) {
		this.firstLogin = firstLogin;
	}
	/**
	 *	To authenticate user name and password
	 *	@param name void
	 *    @exception HibernateException
	 *    @return void
	 *    @see Authenticator
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
	 */

	
	public Authenticator login() {
		Session session = null;

		try {
			session = HibernateManager.getSessionFactory().openSession();

			if (type.equals("A")) {  // check if agent login is tehere

				Agent agent;
				try {

					Query qry = session
							.createQuery(" from Agent A where A.email=:E ");//load the agent with given email Id
					qry.setParameter("E", userName);
					List<Agent> list = qry.list();
					Iterator<Agent> iterator = list.iterator();
					agent = (Agent) iterator.next();
					if (agent.getPassword().equals(password)) { // compare the Password
						Authenticator authenticator = new Authenticator(
								agent.getAgentID(), agent.getName());
						authenticator.setFirstLogin(agent.getFirstLogin());
						return authenticator;
					}//end if

				}//end of try 
				catch (Exception e) {
					return null;
				}//end catch
			}//end if
			if (type.equals("P")) {// check if Policy Holder

				PolicyHolder policyHolder;
				try {
					Query query = session
							.createQuery(" from PolicyHolder P where P.email=:E ");//load the Policy Holder with given email id
					query.setParameter("E", userName);
					List<PolicyHolder> list = query.list();

					Iterator<PolicyHolder> iterator = list.iterator();
					policyHolder = (PolicyHolder) iterator.next();
					if (policyHolder.getPassword().equals(password)) {
						Authenticator authenticator = new Authenticator(
								policyHolder.getUserID(),
								policyHolder.getName());
						authenticator.setFirstLogin(policyHolder
								.getFirstLogin());
						return authenticator;
					}//end if

				}//end try 
				catch (Exception e) {

					return null;
				}//end catch
			}//end try
			
		} //end try
		finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally

		return null;
	}
	/**
	 *	To change the Password
	 *	@param  int
	 *    @exception HibernateException
	 *    @return void
	 *    @see Authenticator
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
	 */
	public int changePassword(String newPassword) {
		Session session = null;

		try {
			session = HibernateManager.getSessionFactory().openSession();

			if (type.equals("A")) {  // check if agent

				Agent agent;
				try {

					Query qry = session
							.createQuery(" from Agent A where A.agentID=:E ");  //load the agent with associated Agent object
					qry.setParameter("E", id);
					List<Agent> list = qry.list();
					Iterator<Agent> iterator = list.iterator();
					agent = (Agent) iterator.next();
					if (agent.getPassword().equals(password)) {
						agent.setFirstLogin(1);
						agent.setPassword(newPassword);
						Transaction trasaction = session.beginTransaction();
						session.update(agent); //change the password
						trasaction.commit();
						return 1;
					} // end if

				}// end try
				catch (Exception e) {
					e.printStackTrace();
					return -1;
				}//end catch
			}
			if (type.equals("P")) { //check if PolicyHolder

				PolicyHolder policyHolder;
				try {

					Query qry = session
							.createQuery(" from PolicyHolder A where A.userID=:E "); //load the Policy Holder with associated email
					qry.setParameter("E", id);
					List<PolicyHolder> list = qry.list();
					Iterator<PolicyHolder> iterator = list.iterator();
					policyHolder = (PolicyHolder) iterator.next();
					if (policyHolder.getPassword().equals(password)) {
						policyHolder.setFirstLogin(1);
						policyHolder.setPassword(newPassword);
						Transaction trasaction = session.beginTransaction();
						session.update(policyHolder); //change the password
						trasaction.commit();
						return 1;
					}//end if
				}//end try 
				catch (Exception e) {
					e.printStackTrace();
					return -1;
				}//end catch
			}//end if
		} finally {
			if (session != null) {
				session.close();
			}//end if
		}//end finally
		return 0;
	}

	/**
	 *	To fetch the password
	 *	@param name void
	 *    @exception HibernateException
	 *    @return void
	 *    @see Authenticator
	 *	@version text
	 *	@author Java_th3_06
	 *    @since 14/02/2016
	 */
	public String fetchPassword() {

		Session session = null;
		try {
			session = HibernateManager.getSessionFactory().openSession();
			if (type.equals("A")) { //If agent
				
				try {
					Query qry = session
							.createQuery(" from Agent A where A.email=:E "); //lad the agent Object
					qry.setParameter("E", userName);
					List<Agent> list = qry.list();
					if (list.size() == 1)
					{
						Agent agent=(Agent)list.get(0);
						
						return agent.getPassword(); //if present return the password
					}//end if
				} 
				catch (Exception e) {
					return "error"; //if not error 
				}//end catch
			}//end if
			if (type.equals("P")) { //if Policy Holder

			
				try {
					Query qry = session
							.createQuery(" from PolicyHolder P where P.email=:E ");
					qry.setParameter("E", userName);//load the Policy holder Object
					List<PolicyHolder> list = qry.list();

					if (list.size() == 1)
					{
						PolicyHolder policyHolder=list.get(0);
						return policyHolder.getPassword();// if present return the password
					}
				} catch (Exception e) {

					return "error";
				}//end catch

			}//end try
		}//end try 
		finally {
			if (session != null)
				session.close();
		}//end finally
	   return "error";
	}


}
