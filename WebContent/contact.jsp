<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/validation.js"></script>

<title>Contact Us</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.6-dist\css\bootstrap.css">

<link rel="stylesheet" type="text/css" href="Templates.css">
<style>
.container-fluid {
	padding: 60px 50px;
}

.bg-grey {
	background-color: "resources\orange.jpg";
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body background="resources\relax.jpg">

	<div class="row">
		<div class="col-ld-1">
			<a href="home.jsp"><button type="button"
					class="btn btn-default pull-left">Home</button></a>
		</div>
	</div>


	<div class="container-fluid bg-grey">
		<h2 class="text-center">CONTACT</h2>
		<div class="row">
			<div class="col-sm-5">
				<p>Contact us and we'll get back to you within 24 hours.</p>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Chennai, TN
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> 044-1515151515
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span>
					myemail@something.com
				</p>
			</div>
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-6 form-group">
						<input class="form-control" id="name" name="name"
							onblur="nameValidate(document.getElementbyId('name').value)"
							placeholder="Name" type="text" required>
					</div>
					<div class="col-sm-6 form-group">
						<input class="form-control" id="email" name="email"
							placeholder="Email" type="email" required>
					</div>
				</div>
				<textarea class="form-control" id="comments" name="comments"
					placeholder="Comment" rows="5" required></textarea>
				<br>
				<div class="row">
					<div class="col-sm-12 form-group">
						<button class="btn btn-default pull-right" type="submit">Send</button>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>