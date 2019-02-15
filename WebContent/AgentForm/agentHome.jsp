<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agent Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
        <link rel="stylesheet" href="AgentForm/assets/css/style.css">
	
 
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
        <li><a href="agentHome.jsp" style="color: black">WELCOME USER </a></li>
        <li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
      </ul>
    
    </div>
</header>
<div class="container-fluid text-center">
  <h2>AGENT SERVICES</h2>
   <br><br><br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-plus-sign"></span>
      <h4><a href="AgentRequestHandler?action=fetchPolicyToAddUser" style="color: black;" > ADD NEW POLICY HOLDER</a></h4>
      <p>Add details of new policy sold</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-file"></span>
      <h4> <a href="AgentRequestHandler?action=viewPolicySold" style="color: black;" > VIEW POLICIES </a> </h4>
      <p>View details of policy sold</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-usd"></span>
      <h4> <a href="AgentRequestHandler?action=viewCommission" style="color: black;" > COMMISSION </a> </h4>
      <p>Calculate commission</p>
    </div>
  </div>
  <br><br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-user"></span>
      <h4> <a href="AgentRequestHandler?action=viewPolicyHolder" style="color: black;" > USER DETAILS </a> </h4>
      <p>View details of the policy holders</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-edit"></span>
      <h4> <a href="AgentRequestHandler?action=viewPersonelDetail" style="color: black;" > UPDATE DETAILS </a> </h4>
      <p>Update your personal details</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-info-sign"></span>
      <h4 style="color:#303030;"> <a href="AgentRequestHandler?action=viewMaturedPolicy" style="color: black;" > POLICY STATUS </a> </h4>
      <p> View details of current policies sold by company</p>
    </div>
  </div>
</div>

</body>
</html>