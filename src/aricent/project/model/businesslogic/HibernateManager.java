/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    : HibernateListener.java
           Principal Author             : Java_Th3_06
           Subsystem Name               : Training Project
           Module Name                  : HibernateManager
           Date of First Release        : 20/01/2016
           Author                       :  Java_Th3_06
           Description                  : To create a single session factory object
           for session factory Objects
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3+06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.model.businesslogic;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 *	To create a single session factory object
 *	@see HibernateManager
 *	@see HibernateManager#buildSessionFactory()
 *  @see HibernateManager#getSessionFactory()
 *	@version text
 *	@author Java_th3_03 
 *  @since  14/02/2016
 */

public class HibernateManager {
	private static SessionFactory sessionFactory = buildSessionFactory(); //make the session Factory object ststic
	 /**
	 *	To bulid a single instance of sessionFactory
	 *    @return SessionFactory Object
	 *    @see HiberbnateManger
	 *	@version text
	 *	@author Java_Th3_06
	 *    @since 14/02/2016
	 */

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {// if not initialized
				Configuration configuration = new Configuration()
						.configure(HibernateManager.class
								.getResource("/hibernate.cfg.xml"));//load the configration
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration
						.getProperties());//apply properties
				ServiceRegistry serviceRegistry = serviceRegistryBuilder
						.build();
				sessionFactory = configuration
						.buildSessionFactory(serviceRegistry); //build the sessionFactory
			}
			return sessionFactory;
		}//end try 
		catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}//end catch
	}
	 /**
		 *	To return instance of sessionFactory
		 *    @return SessionFactory Object
		 *    @see HiberbnateManger
		 *	@version text
		 *	@author Java_Th3_06
		 *    @since 14/02/2016
		 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory; //return the session factory object
	}
	 /**
		 *	To close sessionFactory
		 *    @return SessionFactory Object
		 *    @see HiberbnateManger
		 *	@version text
		 *	@author Java_Th3_06
		 *    @since 14/02/2016
		 */
	public static void shutdown() {
		getSessionFactory().close();
	}
}