/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	                : Admin.java
	  Principal Author      	: Java_th3_06
	  Subsystem Name            : Training
	  Module Name           	: Model classes
	  Date of First Release 	: 20/01/2016
	  Author			        : Java_th3_06
	  Description           	: Model class for accesing DataBase through Hibernate


	  Change History

	  Version      		: 1.0
	  Date(DD/MM/YYYY) 	: 14/02/2016
	  Modified by		:  Initial Release
	  Description of change : Initial Release

***********************************************************************/

package aricent.project.model.modelclasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *	Model class for accessing database through Hibernate
 *	@see Admin
 *	@version text
 *	@author Java_th3_06
 *    @since 14/02/2016
 */

@Entity
@Table(name = "admin_details")
public class Admin {
	@Id
	@Column(name = "AdminId")
	private int adminId;
	@Column(name = "Username")
	private String userName;
	@Column(name = "password")
	private String password;
	/* ======================================================= * 
	ACCESSOR METHODS  
	* ======================================================= */ 

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

}
