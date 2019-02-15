/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    :  HibernateListner.java
           Principal Author             : Java_Th3_06
           Subsystem Name               : Training Project
           Module Name                  : HibernateListner
           Date of First Release        : 20/01/2016
           Author                       :  Java_Th3_06
           Description                  :  To Create the Hibernate session factory
           on creation of first servlet and destroy when last servlet finishes 
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3+06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.model.businesslogic;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
/**
 *	To Create the Hibernate session factory
           on creation of first servlet and destroy when last servlet finishes    
 *	@see HibernateListener
 *	@see HibernateListener#contextDestroyed
 *  @see HibernateListener#contextInitialized
 *	@version text
 *	@author Java_th3_06
 *  @since 14/02/2016
 */

public class HibernateListener implements ServletContextListener {
/**	To Create the Hibernate session factory
           on creation of first servlet 
 *	@param ServletContextEvent event
 *   
 *    @see HibernateListener
 *	  @version text
 *	  @author Java_th3_06
 *    @since 14/02/2016
 */

	public void contextInitialized(ServletContextEvent event) {
		HibernateManager.getSessionFactory(); // Just call the static
												// initializer of that class
	}
	/**	To close the Hibernate session factory
    on completion of work of last of servelet 
*	@param ServletContextEvent event
*    @see HibernateListener
*	  @version text
*	  @author Java_th3_06
*    @since 14/02/2016
*/

	public void contextDestroyed(ServletContextEvent event) {
		HibernateManager.getSessionFactory().close(); // Free all resources

	}
}
