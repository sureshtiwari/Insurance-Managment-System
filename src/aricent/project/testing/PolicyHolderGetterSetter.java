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

import org.junit.Test;

import aricent.project.model.modelclasses.PolicyHolder;

/**
 * @author GUR43540
 *
 */
public class PolicyHolderGetterSetter {
	
	PolicyHolder ph=new PolicyHolder();
	@Test
	public void policyName() {
		ph.setName("ram");
		assertEquals("ram", ph.getName());
	}

}
