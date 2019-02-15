<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.6-dist\css\bootstrap.css">

<link rel="stylesheet" type="text/css" href="Templates.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body background="resources\relax.jpg">
	<header>
	<div class="col-ld-1">
		<a href="home.jsp"><img src="resources\LOGO.png" width="100"
			align="left"></a>
	</div>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#about">ABOUT US</a></li>
			<li><a href="login.jsp">LOGIN</a></li>
			<li><a href="contact.jsp">CONTACT US</a></li>
		</ul>

	</div>
	</header>
	<a href="Userform\firstUser.jsp"><img class="img-rounded"
		src="resources\Register.jpg"
		style="position: absolute; top: 300px; left: 100px; width: 150px; height: 150px; opacity: 0.4; filter: alpha(opacity = 40);">
	<h1>
			<p style="position: absolute; top: 450px; left: 100px;">New User</p>
		</h1></a>
	<a href="Userform\existingUser.jsp"><img class="img-rounded"
		src="resources\User.jpg"
		style="position: absolute; top: 300px; right: 900px; width: 150px; height: 150px; opacity: 0.4; filter: alpha(opacity = 40);">
	<h1>
			<p style="position: absolute; top: 450px; right: 870px;">
				Existing User</p>
		</h1></a>


</body>
</html>