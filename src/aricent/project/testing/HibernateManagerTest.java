/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	                : HibernateManagerTest.java
	  Principal Author      	: th3 group6
	  Subsystem Name            : junit
	  Module Name           	: Training Project
	  Date of First Release 	: 10/02/2016
	  Author			        :th3 group6
       Description           	: used to test Functionality of Hibernate Manager Class


	  Change History

	  Version      		: 1.0
	  Date(DD/MM/YYYY) 	: 10/02/2016
	  Modified by		:  Initial Release
	  Description of change : Initial Release

***********************************************************************/
package aricent.project.testing;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import aricent.project.model.businesslogic.HibernateManager;

public class HibernateManagerTest {

	@Test
	public void testHibernateManager() {
		SessionFactory session=HibernateManager.getSessionFactory();
		assertTrue(session!=null);
		session.close();
	}
    @Test
    public void testHibernateManagersingleInstance() {
		SessionFactory session=HibernateManager.getSessionFactory();
		SessionFactory session1=HibernateManager.getSessionFactory();
		assertTrue(session==session1);
		session.close();
	}
}
