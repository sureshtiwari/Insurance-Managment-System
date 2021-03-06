/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	                :TrainingProject1
	  Principal Author      	:Mageshwaran N
	  Subsystem Name        	:Trainee
	  Module Name           	:Main
	  Date of First Release 	:13/1/2016
	  Author					:Mageshwaran N
	  Description           	:To print the even numbers from 2 to N numbers and then to multiply the each element by 2 and then reverse the arraylist and then print the values.


	  Change History

	  Version      				:1.0
	  Date(DD/MM/YYYY) 			:Feb 13, 2016
	  Modified by				:nil
	  Description of change		:Initial
***********************************************************************/
package aricent.project.testing;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import aricent.project.model.businesslogic.AdminServices;
import aricent.project.model.businesslogic.AgentServices;
import aricent.project.model.businesslogic.HibernateManager;
import aricent.project.model.businesslogic.UserServices;
import aricent.project.model.modelclasses.Admin;
import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.Payment;
import aricent.project.model.modelclasses.Policy;
import aricent.project.model.modelclasses.PolicyHolder;
import aricent.project.model.modelclasses.PolicySold;

/**
 * @author GUR43540
 *
 */
public class AdminServicesTestCase {
	AdminServices admin=new AdminServices();
	UserServices user=new UserServices();
	AgentServices agent=new AgentServices();
	Policy policy=new Policy();
	List<Agent> list;
	List<PolicyHolder> plist;
	List<Policy> poList;
	
	@BeforeClass  public static void addAgent()
	{
		AdminServices admin=new AdminServices();
		int res=admin.addNewAgent("Ramana", "ff", 12335, "rtdatag@resadryag.a", "1980-01-01", "address@wea@213243", "city1");
		
	}
	@Test
	public void AgentNameReturn() {
		list=admin.viewAgentDetails();
		Agent a=list.get((list.size()-1));
		assertEquals("Ramana", a.getName());
	}
	
	@Test
	public void viewAgentDetails() {
		list=admin.viewAgentDetails();
		Agent a=list.get((list.size()-1));
		assertEquals("rtdatag@resadryag.a", a.getEmail());
	}
	@Test
	public void checkPolicyHolder()
	{
		list=admin.viewAgentDetails();
		Agent a=list.get((list.size()-1));
		agent.addNewPolicyHolder(a.getAgentID(), "sam", "state", "123123", 1, 1, "fathersName", 123458976l, "email@a.c", Date.valueOf("1111-11-11"), "address", "city");
		plist=admin.viewPolicyHolderDetails();
		PolicyHolder p=plist.get(plist.size()-1);
		assertEquals("sam", p.getName());
		
	}
	
	@Test
	public void login()
	{
		Admin a=admin.adminLogin("sureshtiwari1993@gmail.com", "What");
		int val=0;
		if(a!=null)
			val=1;
		assertEquals(1, val);
	}
	@AfterClass public static void deleteAgent()
	{
		Session session = null;
		try{
			session=HibernateManager.getSessionFactory().openSession();
			try{
				Query query = session.createQuery(" from Agent A");
				Query q=session.createQuery("from PolicyHolder P");
				
				List<Agent> list1=new ArrayList<Agent>();
				list1=query.list();
				Iterator<Agent> itr=list1.iterator();
				Agent a=new Agent();
				while(itr.hasNext())
				{
					a=new Agent();
					a=itr.next();
				}
				List<PolicyHolder> plist1=new ArrayList<PolicyHolder>();
				plist1=q.list();
				Iterator<PolicyHolder> itr1=plist1.iterator();
				PolicyHolder p=new PolicyHolder();
				while(itr1.hasNext())
				{
					p=new PolicyHolder();
					p=itr1.next();
				}
				
				Transaction transaction = session.beginTransaction();
				session.delete(a);
				session.delete(p);
				transaction.commit();
				
			}
			catch(HibernateException e)
			{
				
			}
		}
		finally{
			if(session!=null){
				session.close();
			}
		}
	}
	
	
}
