<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.6-dist\css\bootstrap.css">
	<link rel="stylesheet" type="text/css" href="AgentForm/Agentcss.css">
 
<link rel="stylesheet" type="text/css" href="Templates.css">
 
  <style>
  .jumbotron {
      background-color: #f4511e;
      color: #fff;
      padding: 100px 25px;
  }
  .container-fluid {
      padding: 60px 50px;
  }
  .bg-grey {
      background-color: #f6f6f6;
  }
  .logo {
      font-size: 200px;
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
  }
  </style>
</head>
<body >

<header>

    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="adminHome.jsp" style="color: black">WELCOME USER </a></li>
        <li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
      </ul>
    
    </div>
</header>

<div class="container-fluid text-center">
  <h2>ADMIN SERVICES</h2>
   <br><br><br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-plus-sign"></span>
      <h4><a href="/TrainingProject1/Admin/addAgent.jsp" style="color: black;" > ADD AGENT</a></h4>
      <p>Add details of new agent</p>
    </div>
    
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-user"></span>
      <h4> <a href="AdminRequestHandler?action=viewAgentDetails" style="color: black;" > AGENT DETAILS </a> </h4>
      <p>View details of the agents</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-list-alt"></span>
      <h4> <a href="AdminRequestHandler?action=viewPolicySoldDetails" style="color: black;" > POLICY SOLD DETAILS</a> </h4>
      <p>View transaction reports for policies</p>
    </div>
  </div>
  <br><br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-plus-sign"></span>
      <h4> <a href="Admin/addPolicy.jsp" style="color: black;" > ADD POLICY </a> </h4>
      <p>Add details about new policy</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-user"></span>
      <h4> <a href="AdminRequestHandler?action=viewPolicyHolderDetails" style="color: black;" > POLICY HOLDER DETAILS </a> </h4>
      <p>View details of the policy holders </p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-list-alt"></span>
      <h4 style="color:#303030;"> <a href="AdminRequestHandler?action=viewPaymentDetails" style="color: black;" > PAYMENT DETAILS </a> </h4>
      <p> View details of the payments made by policy holder</p>
    </div>
  </div>
</div>

</body>
</html>