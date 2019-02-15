<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Login Form</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="Userform/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="Userform/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="Userform/assets/css/form-elements.css">
<link rel="stylesheet" href="Userform/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="Templates.css">




</style>
<script type="text/javascript" src="validation.js">
	
</script>
</head>
<body style="background-color: #524848">

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#about">ABOUT US</a></li>
			<li><a href="contact.jsp">CONTACT US</a></li>
		</ul>

	</div>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>Change your password</h3>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="LoginHandler" method="post"
								class="login-form">
								<div class="form-group">
									<input type="hidden" name="action" value="changePassword">
									<label class="sr-only" for="form-oldPassword"
										style="color: black;">OldPassword:</label> <input type="password"
										name="oldPassword" placeholder="Old Password.."
										class="form-oldPassword form-control" id="oldpassword">

								</div>

								<div class="form-group">
									<label class="sr-only" for="form-username"
										style="color: black;">NewPassword:</label> <input type="password"
										name="newPassword" placeholder="New Password.."
										class="form-username form-control" id="newpassword">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password"
										style="color: black;">Confirm New Password:</label> <input
										type="password" name="confirmpassword"
										placeholder="Confirm New Password.."
										class="form-password form-control" id="confirmpassword">
								</div>
								<button type="submit" class="btn">Change Password!</button>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>




</body>
</html>