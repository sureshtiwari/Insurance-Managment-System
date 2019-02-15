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
	  Date(DD/MM/YYYY) 			:Feb 14, 2016
	  Modified by				:nil
	  Description of change		:Initial
***********************************************************************/

package aricent.project.testing;
import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aricent.project.model.businesslogic.AdminServices;
import aricent.project.model.businesslogic.AgentServices;
import aricent.project.model.businesslogic.HibernateManager;
import aricent.project.model.modelclasses.Admin;
import aricent.project.model.modelclasses.Agent;
import aricent.project.model.modelclasses.Policy;
import aricent.project.model.modelclasses.PolicyHolder;

/**
 * @author GUR43540
 *
 */
public class AdminAddPolicy {

	@BeforeClass  public static void addAgent()
	{
		
		
	}
	
	@Test
	public void addPolicy()
	{
		AdminServices admin=new AdminServices();
		AgentServices agent=new AgentServices();
		admin.addNewPolicy("policyName", "pType", 24, 2000, 25000);
		List<Policy> poList=new ArrayList<Policy>();
		poList=agent.viewPolicy();
		Policy p=poList.get(poList.size()-1);
		assertEquals("policyName", p.getPolicyName());
	}
	
	
	@AfterClass public static void deleteAgent()
	{
		Session session = null;
		try{
			session=HibernateManager.getSessionFactory().openSession();
			try{
				Query po=session.createQuery("from Policy P");
				
	
				List<Policy> polist1=new ArrayList<Policy>();
				polist1=po.list();
				Iterator<Policy> itr2=polist1.iterator();
				Policy pol=new Policy();
				while(itr2.hasNext())
				{
					pol=new Policy();
					pol=itr2.next();
				}
				
				Transaction transaction = session.beginTransaction();
				session.delete(pol);
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
