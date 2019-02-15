<%@page import="aricent.project.model.modelclasses.Policy"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User Register Form</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
        <link rel="stylesheet" href="AgentForm/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="..\Templates.css">

       

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
        <style>
        @import "font-awesome.min.css";
@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
  padding-top: 20px;
  padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header,
.marketing,
.footer {
  padding-right: 15px;
  padding-left: 15px;
}

/* Custom page header */
.header {
  border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  padding-bottom: 19px;
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}

/* Custom page footer */
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media (min-width: 768px) {
  .container {
    max-width: 730px;
  }
}
.container-narrow > hr {
  margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

/* Supporting marketing content */
.marketing {
  margin: 40px 0;
}
.marketing p + h4 {
  margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
  /* Remove the padding we set earlier */
  .header,
  .marketing,
  .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 30px;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
        </style>

</head>
<body background="resources\relax.jpg" >
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#about">ABOUT US</a></li>
        <li><a href="contact.jsp">CONTACT US</a></li>
      </ul>
    
    <div class="container">
    <h1 class="well">Registration Form</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form name="myform" action="AgentRequestHandler" method="post" onsubmit="return overAllValidate(document.getElementById('name').value,document.getElementById('lastname').value,document.getElementById('address').value,document.getElementById('zip').value,document.getElementById('fathersname').value,document.getElementById('dob').value,document.getElementById('phonenumber').value,document.getElementById('email').value,document.getElementById('policyId').value)" >
					<div class="col-sm-12">
					<input type="hidden" name="action" value="addPolicyHolder">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								<input type="text" placeholder="Enter First Name Here.." class="form-control" name="firstname" onblur="nameValidate(document.getElementById('name').value)" id="name">
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<input type="text" placeholder="Enter Last Name Here.." class="form-control" name="lastname" onblur="nameValidate(document.getElementById('lastname').value)" id="lastname">
							</div>
						</div>					
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." rows="3" class="form-control" name="address" onblur="addressValidate(document.getElementById('address').value)" id="address"></textarea>
						</div>	
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>City</label>
								<input type="text" placeholder="Enter City Name Here.." class="form-control" name="city" onblur="nameValidate(document.getElementById('city').value)" id="city">
							</div>	
							<div class="col-sm-4 form-group">
								<label>State</label>
								<input type="text" placeholder="Enter State Name Here.." class="form-control" name="state" onblur="nameValidate(document.getElementById('state').value)" id="state">
							</div>	
							<div class="col-sm-4 form-group">
								<label>Zip</label>
								<input type="text" placeholder="Enter Zip Code Here.." class="form-control" name="zip" onblur="zipValidate(document.getElementById('zip').value)" id="zip">
							</div>		
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Father's Name</label>
								<input type="text" placeholder="Enter Father's name here.." class="form-control" name="fathersname" onblur="nameValidate(document.getElementById('fathersname').value)" id="fathersname">
							</div>		
							<div class="col-sm-6 form-group">
								<label>DOB</label>
								<input type="text" placeholder="DD/MM/YYYY" class="form-control" name="dob" onblur="dobValidate(document.getElementById('dob').value)" id="dob">
							</div>	
						</div>
							
					<div class="form-group">
						<label>Phone Number</label>
						<input type="text" placeholder="Enter Phone Number Here.." class="form-control" name="phonenumber" onblur="mobileNumberValidate(document.getElementById('phonenumber').value)" id="phonenumber">
					</div>		
					<div class="form-group">
						<label>Email Address</label>
						<input type="text" placeholder="Enter Email Address Here.." class="form-control" name="email" onblur="emailValidate(document.getElementById('email').value)" id="email">
					</div>	
					<label><center>PaymentMode</center></label><br>
					
			
<label class="radio-inline"><input type="radio" name="payMode" id="r1" value="1">Monthly</label>
<label class="radio-inline"><input type="radio" name="payMode" id="r2" value="3">Quaterly</label>
<label class="radio-inline"><input type="radio" name="payMode" id="r3" value="6">Half Yearly</label>
<label class="radio-inline"><input type="radio" name="payMode" id="r4" value="12">Yearly</label><br>
<label>PolicyName</label>
 
<select Id="policyId" name="policyId" onblur="dropDownValidate(document.getElementById('policyId').value)">
	<option value="blank" id="option" disabled selected>Select policy(Policy Name-Type-Amount-Duration)</option>
    <%
    List<Policy> list=new ArrayList<Policy>();
			list=(List<Policy>)request.getAttribute("PolicyDetails");
			Iterator<Policy> iterator = list.iterator();
			Policy e;
			while (iterator.hasNext()) {
				e = iterator.next();
		%>
		
     <option value="<%=e.getPolicyID() %>" ><%= e.getPolicyName() %>-<%=e.getPolicyType() %>-<%=e.getTotalAmount() %>-<%=e.getDuration() %></option>
		
		<%
			}
		%>
		</select>  
<br>
					<button type="submit" class="btn btn-lg btn-info" >Submit</button>					
					</div>
				</form> 
				</div>
	</div>
	</div>
        

    </body>

</html>