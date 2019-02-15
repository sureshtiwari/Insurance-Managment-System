<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	HttpSession session1 = request.getSession();
	session1.invalidate();
%>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.6-dist\css\bootstrap.css">

<link rel="stylesheet" type="text/css" href="Templates.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="Userform/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="Userform/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="Userform/assets/css/form-elements.css">
<link rel="stylesheet" href="Userform/assets/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<script type="text/javascript">
	 window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body background="resources\relax.jpg" onload="noBack();"     onpageshow="if (event.persisted) noBack();"
	 onunload="noBack();">
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


	<div class="top-content">

		<div class="inner-bg">
			<div class="container">

				<div class="row">
					<div class="col-sm-7 col-sm-offset-1 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>You have been Logged Out Successfully!</h3>
								<p>Thankyou for Visiting our WebSite!!!!</p>
							</div>

						</div>

					</div>
				</div>

			</div>
		</div>

	</div>





</body>
</html>