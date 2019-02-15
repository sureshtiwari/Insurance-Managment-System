<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../validation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Policy</title>

<title>Policy Register Form</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="../AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="../AgentForm/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="..\Templates.css">



<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<style>
@import "font-awesome.min.css";

@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
	padding-top: 20px;
	padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
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
@media ( min-width : 768px) {
	.container {
		max-width: 730px;
	}
}

.container-narrow>hr {
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

.marketing p+h4 {
	margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
	/* Remove the padding we set earlier */
	.header, .marketing, .footer {
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
<body background="resources\relax.jpg">
	<header>
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="adminHome.jsp">ADMIN HOME</a></li>
			<li><a href="../logout.jsp">LOGOUT</a></li>
		</ul>
	</div>
	</header>
	<%
		String s = "";
		s = (String) request.getAttribute("true");
		if (s != null) {
	%><script type="text/javascript">alert("<%=s%>
					");
				</script>
	<%
		}
	%>

	<div class="container">
		<center>
			<h1 class="well">Add New Policy</h1>
		</center>
		<div class="col-lg-12 well">
			<div class="row">
				<form action="../AdminRequestHandler" method="post" onsubmit=" return overAllPolicyValidate(document.getElementById('pname').value,document.getElementById('ptype').value,document.getElementById('duration').value, document.getElementById('tamount').value,document.getElementById('commission').value)">
					<div class="col-sm-12">
						<input type="hidden" name="action" value="addNewPolicy" 	>
						<div class="form-group">
							<label>Policy Name</label> <input type="text"
								placeholder="Enter Policy Name Here.." rows="3" name="pname" id="pname" onblur="policyValidate(document.getElementById('pname').value)"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Policy Type</label> <input type="text"
								placeholder="Enter Policy Type Here.." rows="3" name="ptype" id="ptype" onblur="policytypeValidate(document.getElementById('ptype').value)""
								class="form-control">
						</div>
						<div class="form-group">
							<label>Duration</label> <input type="text"
								placeholder="Enter Policy Duration Here.." rows="3"
								name="Duration" id="duration" onblur="durationValidate(document.getElementById('duration').value)"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Total Amount</label> <input type="text"
								placeholder="Enter Total Amount Here.." rows="3" name="Tamount" id="tamount" onblur="amountValidate(document.getElementById('tamount').value)"
								class="form-control">
						</div>
						<div class="form-group">
							<label>Commision</label> <input type="text"
								placeholder="Enter Commision Here.." rows="3" name="Comm" id="commission" onblur="commissionValidate(document.getElementById('commission').value)"
								class="form-control">
						</div>

						<center>
							<button type="submit" class="btn btn-lg btn-info"
								>Submit</button>
						</center>
					</div>
				</form>
			</div>
		</div>
	</div>




</body>
</html>