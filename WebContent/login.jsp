<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.6-dist\css\bootstrap.css">

<link rel="stylesheet" type="text/css" href="Templates.css">
<style>
</style>
<title>Login</title>
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


	<!-- <h2><p align="center">LOGIN</p></h2> -->
	<section> <a href="Userform\existingUser.jsp"><img
		class="img-rounded" src="resources\Users.png"
		style="position: absolute; top: 300px; left: 100px; width: 150px; height: 150px; opacity: 0.4; filter: alpha(opacity = 40);">
	<h1>
			<p style="position: absolute; top: 450px; left: 130px;">User</p>
		</h1></a> <a href="AgentForm\agentLogin.jsp"><img class="img-rounded"
		src="resources\Agentss.png"
		style="position: absolute; top: 300px; right: 900px; width: 150px; height: 150px; opacity: 0.4; filter: alpha(opacity = 40);">
	<h1>
			<p style="position: absolute; top: 450px; right: 940px;">Agent</p>
		</h1></a> </section>

</body>
</html>