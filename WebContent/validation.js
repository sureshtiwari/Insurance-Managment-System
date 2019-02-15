function emailValidate(inputText) {
	var reg = /^[_a-zA-Z0-9]+(\.[_a-zA-Z0-9]+)*@[a-z0-9]+(\.[a-zA-Z0-9]+)*(\.[a-zA-Z]{2,3})$/;
	if (reg.test(inputText)) {
		// alert("correct email format");
		return true;
	} else {
		alert("You have entered an invalid Email Address!");
		return false;
	}
}
function loginValidate(inputText, password) {
	var check = emailValidate(inputText);
	if (check == true) 
	{
		if (password != '') 
		{
			return true;
		}
		alert('Enter the Password');
		return false;
	} else {

		return false;
	}
}
function passwordEqual(password1, password2) {
	if (password1 == password2) {
		passwordValidate(password1);
	} else {
		alert("both the fields are not equal");
		return false;
	}
}
function passwordValidate(password) {
	// var password = document.SetPassword.Pass.value;
	var Stringlen = password.length;
	var count = 0;
	var message = "";

	if (Stringlen < 6) {
		message += "Passwords must be at least 6 characters";
		count = 1;
	}
	if (!(/[!@#$%^&*]+/.test(password))) {
		message += "Passwords must include at least 1 special (#,@,&,$ etc) characters";

		count = 1;
	}
	if (!(/[0-9]+/).test(password)) {
		message += "Passwords must include at least 1 numeric characters";
		count = 1;
	}
	if (count == 0) {
		// alert("success");
		return true;
		// window.open("RegisteredUser.jsp");

	} else {
		alert(message);
		return false;
	}
}

function zipValidate(zip) {
	var format = /[0-9]{6}$/;
	if (format.test(zip))
		return true;
	else {
		alert("Pincode should only contain number and should be of length 6");
		return false;
	}

}

function nameValidate(name) {

	var format = /^[a-zA-Z]+$/;
	if (format.test(name)) {
		// alert("correct");
		return true;
	} else {
		alert("This field cannot be left Blank and Can only hold Alphabet");
		return false;
	}
}

function dobValidate(dob) {
	var format = /^([0-9]{1,2})\/([0-9]{1,2})\/([0-9]{4})+$/;
	var date = new Date();
	var currentDay = date.getDay();
	var currentMonth = date.getFullYear();
	var currentYear = date.getFullYear();
	var data = dob.split("/");
	if (format.test(dob)) {
		if ((data[1] <= 12) && (data[1] != 0) && (data[0] != 0)
				&& (data[2] != 0)) {
			if ((data[1] == 1) || (data[1] == 3) || (data[1] == 5)
					|| (data[1] == 7) || (data[1] == 8) || (data[1] == 10)
					|| (data[1] == 12)) {
				if (data[0] <= 31 && data[0] != 0) {
					return true;
				} else {
					alert(" day should between 1 and 31");
					return false;
				}
			} else if ((data[1] == 4) || (data[1] == 6) || (data[1] == 9)
					|| (data[1] == 11)) {
				if (data[0] <= 30 && data[0] != 0) {
					return true;
				} else {
					alert(" day should between 1 and 30");
					return false;
				}
			} // else if for 30 days
			else {
				if (((data[2] % 4 == 0) && !(data[2] % 100 == 0))
						|| (data[2] % 400 == 0)) {
					if (data[0] <= 29 && data[0] != 0) {
						return true;
					} else {
						alert(" day should between 1 and 29");
						return false;
					}

				} else {
					if (data[0] <= 28 && data[0] != 0) {
						return true;
					} else {
						alert(" day should between 1 and 28");
						return false;
					}
				}

			}
		} else {
			alert("Invalid Date....Please Enter the Date of Birth According to the Format");
			return false;
		}

	} // first if for dob format
	else {
		alert("Invalid Date....Please Enter the Date of Birth According to the Format");
		return false;
	}
}

function mobileNumberValidate(number) {
	var format = /^[1-9]{1}[0-9]{9}$/;
	if (format.test(number)) {
		return true;
	} else {
		alert("Mobile Number should contain only numbers and should be of length 10 only");
		return false;
	}
}
function addressValidate(address) {
	if (address == '') {
		alert("address field cannot be empty");
		return false;
	}
	if(/^[@%$]+$/.test(address)) {
		alert("address field does not contain (@,%,$)");
	//address.focus();
	return false;
	}
	return true;
}
function overAllValidate(fname, lname, address,zip,fatherName, dob, number, email,selected) {
	
	
	if (nameValidate(fname) && nameValidate(lname) && dobValidate(dob)
			&& nameValidate(fatherName) && mobileNumberValidate(number)
			&& emailValidate(email) && zipValidate(zip) && dropDownValidate(selected) && check() ) {
		
		return true;
	} else {
		alert("Some fields are missing or wrong check the fields again");
		return false;
	}
}


function policyModeValidate(mode, PolicyMode) {
	var spt = mode.split("-");
	var duration = spt[1];
	var premiumPaid = spt[2];
	var remainingMonths = duration - premiumPaid;
	if (spt[3] == PolicyMode) {
		alert("You selected your current policy mode, choose some other mode");
		return false;
	}

	else if (remainingMonths % PolicyMode == 0) {
		return true;
	} else if (remainingMonths < PolicyMode) {
		alert("Your remaing months are less than the policy mode");
		return false;
	} else {
		var noMonths = remainingMonths % PolicyMode;
		alert("Pay for next " + noMonths + " month and change to this mode");
		return false;
	}
}

function amountValidate(number) {
	var format = /^[0-9]+(\.)*([0-9])+$/;
		if (format.test(number)) {
			if (/^[0]+(\.)*([0])+$/.test(number)) {
				alert("amount should not be zero");
				return false;
			}
			return true;
		} else {
			alert(" amount field should contain numbers only");
			return false;
		}
	
}
function dropDownValidate(selected) {
	if (selected =="blank") {
		alert("select an option ");
		return false;
	} else {
		return true;
	}

}

function dropDownPolicyValidate(selected) {
	if (selected = "Select policy(Policy Name-Type-Amount-Duration)") {
		alert("Select an option from the Policy");
		return false;
	} else {
		return true;
	}

}
function check()    {

	chosen = ""
	len = document.myform.payMode.length
	for (i = 0; i <len; i++) {
	if (document.myform.payMode[i].checked) {
		
	chosen = document.myform.payMode[i].value
	}
	}

	if (chosen == "") {
	alert("No Option selected");
	return false;
	}
	else {
	return true;
	}
	}
function selectValidate()    {
	chosen = ""
	len = document.myform.decision.length
	for (i = 0; i <len; i++) {
	if (document.myform.decision[i].checked) {
		
	chosen = document.myform.decision[i].value
	}
	}

	if (chosen == "") {
	alert("No Option selected");
	return false;
	}
	else {
	return true;
	}
	}
function stateValidate(state) {
	if(/^[a-zA-Z]+$/.test(state)) {
	return true;
	}
	else {
	alert("state field does not contain special characters and numbers");
	return false;
	}
}
function cityValidate(city) {
	if(/^[a-zA-Z]+$/.test(city)) {
	return true;
	}
	else {
	alert("city field does not contain special characters and numbers");
	return false;
	}
}
function updateValidate(name,number,address,city,state,zip) {
	if(nameValidate(name)&&mobileNumberValidate(number)&&addressValidate(address)&&cityValidate(city)&&stateValidate(state)&&zipValidate(zip)) {
	return true;	 
	}
	
	else {
		alert("some fields are missing");
		return false;
	}
	}
function policyValidate(policy) {
	if(/^[a-zA-Z]+$/.test(policy)) {
		return true;
	}
	else {
		alert("Policy Name should contain alphabets only");
		return false;
	}
}
function policytypeValidate(policytype) {
	if(/^[a-zA-Z]+$/.test(policytype)) {
		return true;
	}
	else {
		alert("policytype should be like alphabets only");
		return false;
	}
	
}
function durationValidate(duration) {
	if(/^[0-9]+$/.test(duration)) {
		return true;
	}
	else {
		alert("duration contains only numbers");
		return false;
	}
}
function commissionValidate(commission) {
	if(/^[0-9]+$/.test(commission)) {
		return true;
	}
	else {
		alert("commission contains only numbers");
		return false;
	}
}
function overAllPolicyValidate(policy,policytype,duration,amount,commission) {
	if( policyValidate(policy) && policytypeValidate(policytype) && durationValidate(duration) && amountValidate(amount) && commissionValidate(commission)) {
		return true;
	}
	else {
		alert("some fields are missing");
		return false;
	}
	
}

function addAgentValidate(fname,lname,address,city,state,fathername,dob,number,zip,email) {

	
	if (nameValidate(fname) && nameValidate(lname) && addressValidate(address) && dobValidate(dob)
			&& nameValidate(fatherName) && cityValidate(city) && stateValidate(state) && mobileNumberValidate(number)
			&& emailValidate(email) && zipValidate(zip) ) {
		
		return true;
	}
	else {
		
		alert("some fields are missing");
		return false;
	}
	//addAgentValidate(document.getElementById('fname').value,document.getElementById('lname').value,document.getElementById('address').value,document.getElementById('city').value),document.getElementById('state').value,document.getElementById('fathername').value,document.getElementById('dob').value,document.getElementById('phNumber').value,document.getElementById('zip').value,document.getElementById('email').value)
	
}
