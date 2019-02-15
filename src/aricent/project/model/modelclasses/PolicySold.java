/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	                : PolicySold.java
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

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *	Model class for accessing database through Hibernate
 *	@see PolicySold
 *	@version text
 *	@author Java_th3_06
 *    @since 14/02/2016
 */
@Entity
@Table(name = "policy_sold")
public class PolicySold implements Comparable<PolicySold> {
	@Id
	@Column(name = "Transaction_ID")
	private int transactionID;
	@Column(name = "User_ID")
	private int userID;
	@Column(name = "Policy_ID")
	private int policyID;
	@Column(name = "Agent_ID")
	private int agentID;
	@Column(name = "Payment_Mode")
	private int paymentMode;
	@Column(name = "Total_Premium")
	private int noOfPremium;
	@Column(name = "Premium_Paid")
	private int premiumPaid;
	@Column(name = "Start_Date")
	private Date startDate;
	/* ======================================================= * 
	ACCESSOR METHODS  
	* ======================================================= */
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getPolicyID() {
		return policyID;
	}

	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getNoOfPremium() {
		return noOfPremium;
	}

	public void setNoOfPremium(int noOfPremium) {
		this.noOfPremium = noOfPremium;
	}

	public int getPremiumPaid() {
		return premiumPaid;
	}

	public void setPremiumPaid(int premiumPaid) {
		this.premiumPaid = premiumPaid;
	}

	@Override
	public int compareTo(PolicySold policySold) {
		// TODO Auto-generated method stub
		return ((Integer) policySold.getTransactionID())
				.compareTo((Integer) this.getTransactionID());
	}

}