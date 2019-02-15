<%@page import="aricent.project.model.modelclasses.PolicyHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm User</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="AgentForm/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="Templates.css">



<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
<style>
</style>

</head>

<body style="background-color: #524848">
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Back</a></li>
			<li><a href="home.jsp">Home</a></li>
		</ul>

	</div>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<center>
							<h1>
								<strong>Policy Holder Confirmation</strong>
							</h1>
						</center>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">

								<p>Confirm the details of the policy holder</p>
							</div>

						</div>
						<%
							PolicyHolder policyHolder = (PolicyHolder) request
									.getAttribute("policyHolder");
							String policyId = request.getParameter("policyId");
							String payMode = request.getParameter("payMode");
						%>
						<div class="form-bottom">

							<form role="form" method="post" action="AgentRequestHandler" name="myform" onsubmit="return selectValidate()"
								class="login-form">
								<input type="hidden" name="action" value="addPolicyHolder1">
								<div class="form-group">
									<h4>
										<b>NAME:</b><%=policyHolder.getName()%></h4>
								</div>
								<div class="form-group">
									<h4>
										<b>Email:</b><%=policyHolder.getEmail()%></h4>
								</div>
								<div class="form-group">
									<h4>
										<b>DOB:</b><%=policyHolder.getDob()%></h4>
								</div>

								<label class="radio-inline"><input type="radio"
									name="decision" value="yes">Yes</label><br> <label
									class="radio-inline"><input type="radio"
									name="decision" value="no">No</label><br> *Pressing "Yes"
								will add the policy to the Existing User.<br> *Pressing
								"No" to Create a New Policy Holder With Unique E-mail ID. <input
									type="hidden" name="policyHolder"
									value="<%=policyHolder.getUserID()%>"> <input
									type="hidden" name="policyId" value="<%=policyId%>"> <input
									type="hidden" name="payMode" value="<%=payMode%>">

								<button type="submit" class="btn">Submit!</button>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>




</body>

</html>
