/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	                : Agent.java
	  Principal Author      	: Java_th3_06
	  Subsystem Name            : Training
	  Module Name           	: Model Classes
	  Date of First Release 	: 20/01/2016
	  Author			        : Java_th3_06
	  Description           	: Model class for accessing DataBase through Hibernate


	  Change History

	  Version      		: 1.0
	  Date(DD/MM/YYYY) 	: 14/02/2016
	  Modified by		:  Initial Release
	  Description of change : Initial Release

***********************************************************************/
package aricent.project.model.modelclasses;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *	Model class for accessing database through Hibernate
 *	@see Agent
 *	@version text
 *	@author Java_th3_06
 *    @since 14/02/2016
 */
@Entity
@Table(name = "Agent_details")
public class Agent {

	@Id
	@Column(name = "Agent_ID")
	private int agentID;
	private String name;
	@Column(name = "fathers_Name")
	private String fathersName;
	@Column(name = "phone_Number")
	private long phoneNumber;
	private String email;
	private Date dob;
	private String password;
	private String address;
	private String city;
	@Column(name = "First_login")
	private int firstLogin;

	/* ======================================================= * 
	ACCESSOR METHODS  
	* ======================================================= */ 
	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(int firstLogin) {
		this.firstLogin = firstLogin;
	}

}
