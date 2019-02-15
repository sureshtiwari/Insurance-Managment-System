/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	                : Policy.java
	  Principal Author      	: Java_th3_06
	  Subsystem Name            : Training
	  Module Name           	: Policy Module
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *	Model class for accessing database through Hibernate
 *	@see Policy
 *	@version text
 *	@author Java_th3_06
 *  @since 14/02/2016
 */
@Entity
@Table(name = "policy")
public class Policy {
	@Id
	@Column(name = "Policy_ID")
	private int policyID;
	@Column(name = "Policy_Type")
	private String policyType;
	@Column(name = "Policy_Name")
	private String policyName;
	@Column(name = "Duration")
	private int duration;
	@Column(name = "Total_Amount")
	private double totalAmount;
	@Column(name = "Commission")
	private int commission;
	@Column(name = "InterestRate")
	private float interestRate;
	/* ======================================================= * 
	ACCESSOR METHODS  
	* ======================================================= */
	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public int getPolicyID() {
		return policyID;
	}

	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
