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

import aricent.project.model.businesslogic.AdminServices;
import aricent.project.model.modelclasses.Admin;

/**
 * @author GUR43540
 *
 */
public class AdminGetterSetter {
	
	Admin admin=new Admin();
	@Test
	public void AdminId() {
		admin.setAdminId(1);
		assertEquals(1, admin.getAdminId());
	}
	@Test
	public void adminPassword(){
		admin.setPassword("asd");
		assertEquals("asd", admin.getPassword());
	}

}
