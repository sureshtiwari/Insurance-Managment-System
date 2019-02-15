<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" type="text/css"
	href="\bootstrap-3.3.6-dist\css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="/AgentForm/Agentcss.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="Userform/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="Userform/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="Userform/assets/css/form-elements.css">
<link rel="stylesheet" href="Userform/assets/css/style.css">

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
<body style="background-color: #00bfff">
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/Userform/userHome.jsp" style="color: black">WELCOME
					USER </a></li>
			<li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<div class="container-fluid text-center">
		<h2>USER SERVICES</h2>
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-plus-sign"></span>
				<h4>
					<a href="UserRequestHandler?action=changeMode1"
						style="color: black;"> CHANGE MODE</a>
				</h4>
				<p>Change the mode of the policy</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-list-alt"></span>
				<h4>
					<a href="UserRequestHandler?action=viewPolicy"
						style="color: black;"> VIEW POLICIES </a>
				</h4>
				<p>View details of policy taken</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-file"></span>
				<h4>
					<a href="UserRequestHandler?action=viewPayStatement"
						style="color: black;"> PAY STATEMENT </a>
				</h4>
				<p>Generates the pay statement</p>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-user"></span>
				<h4>
					<a href="UserRequestHandler?action=viewAgent" style="color: black;">
						AGENT DETAILS </a>
				</h4>
				<p>View details of your Agent</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-edit"></span>
				<h4>
					<a href="UserRequestHandler?action=viewDetails"
						style="color: black;"> UPDATE DETAILS </a>
				</h4>
				<p>Update your personal details</p>
			</div>
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-info-sign"></span>
				<h4 style="color: #303030;">
					<a href="UserRequestHandler?action=viewPolicyMatured"
						style="color: black;"> POLICY STATUS </a>
				</h4>
				<p>Get the matured policies</p>
			</div>
		</div>
		<br>
		<br>
		<div class="col-sm-4">
			<span></span>
			<h4></h4>
			<p></p>
		</div>
		<div class="row">
			<div class="col-sm-4" align="center">
				<span class="glyphicon glyphicon-usd"></span>
				<h4>
					<a href="UserRequestHandler?action=payment1" style="color: black;">
						Payment</a>
				</h4>
				<p>Pay for policies</p>
			</div>
		</div>
	</div>

</body>