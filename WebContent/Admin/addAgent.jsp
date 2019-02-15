<!DOCTYPE html>
<html lang="en">

<head>
<script type="text/javascript" src="../validation.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Agent Form</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="AgentForm/assets/css/style.css">
<link rel="stylesheet" type="text/css"
	href="..\bootstrap-3.3.6-dist\css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="Agentcss.css">

<link rel="stylesheet" type="text/css" href="..\Templates.css">



<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="AgentForm/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="AgentForm/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="AgentForm/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
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



	<div class="container">
		<h1 class="well">Add Agent Form</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form action="../AdminRequestHandler" method="post" onsubmit="return addAgentValidate(document.getElementById('fname').value,document.getElementById('lname').value,document.getElementById('address').value,document.getElementById('city').value,document.getElementById('state').value,document.getElementById('fathername').value,document.getElementById('dob').value,document.getElementById('phNumber').value,document.getElementById('zip').value,document.getElementById('email').value)">
					<div class="col-sm-12">
						<input type="hidden" name="action" value="addNewAgent">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label> <input type="text"
									placeholder="Enter First Name Here.." name="fname" id="fname"
									class="form-control"
									onblur="nameValidate(document.getElementById('fname').value)">
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label> <input type="text"
									placeholder="Enter Last Name Here.." name="lname"
									class="form-control" id="lname"
									onblur="nameValidate(document.getElementById('lname').value)">
							</div>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." rows="3"
								name="address" class="form-control" id="address"
								onblur="addressValidate(document.getElementById('address').value)"></textarea>
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>City</label> <input type="text"
									placeholder="Enter City Name Here.." name="city"
									class="form-control" id="city"
									onblur="cityValidate(document.getElementById('city').value)">
							</div>
							<div class="col-sm-4 form-group">
								<label>State</label> <input type="text"
									placeholder="Enter State Name Here.." name="state"
									class="form-control" id="state"
									onblur="stateValidate(document.getElementById('state').value)">
							</div>
							<div class="col-sm-4 form-group">
								<label>Zip</label> <input type="text"
									placeholder="Enter Zip Code Here.." name="zip"
									class="form-control" id="zip"
									onblur="zipValidate(document.getElementById('zip').value)">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Father's Name</label> <input type="text"
									placeholder="Enter Father's name here.." name="fathername"
									class="form-control" id="fathername"
									onblur="nameValidate(document.getElementById('fathername').value)">
							</div>
							<div class="col-sm-6 form-group">
								<label>DOB</label> <input type="text" placeholder="DD/MM/YYYY"
									name="dob" class="form-control" id="dob"
									onblur="dobValidate(document.getElementById('dob').value)">
							</div>
						</div>
						<!-- <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
                    <div class="col-sm-9">
                        <input type="date" id="birthDate" class="form-control">
                    </div>
                </div>				 -->
						<div class="form-group">
							<label>Phone Number</label> <input type="text"
								placeholder="Enter Phone Number Here.." name="phone"
								class="form-control" id="phNumber"
								onblur="mobileNumberValidate(document.getElementById('phNumber').value)">
						</div>
						<div class="form-group">
							<label>Email Address</label> <input type="text"
								placeholder="Enter Email Address Here.." name="email"
								class="form-control" id="email"
								onblur="emailValidate(document.getElementById('email').value)">
						</div>

						<center>
							<button type="submit" class="btn btn-lg btn-info">Submit</button>
						</center>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>

</html>