<%@page import="javax.swing.text.Document"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>UserPayment</title>

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

</head>
<body style="background-color: #524848">
	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#about">ABOUT US</a></li>
			<li><a href="..\contact.jsp">CONTACT US</a></li>
		</ul>
	</div>
	<%
		List<List<Object>> list = new ArrayList<List<Object>>();
		list = (List<List<Object>>) request.getAttribute("selectPolicy");
		int size = list.size();
	%>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<%
								if (size == 0) {
							%>
							<h3 align="center">No payment due for your policies!</h3>
							<%
								}
							%>
							<div class="form-top-left">
								<%
									if (size > 0) {
								%>
								<h3>Select Your Policy</h3>

							</div>
							<div class="form-top-right">
								<i class="fa fa-edit"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="Userform/userPayment.jsp" method="post" onsubmit="return dropDownValidate(document.getElementById('val').value)">
								class="login-form">
								<div class="form-group">
									<p>Select policy:</p>
									<select name="values" id="val">

										<%
											for (List<Object> l : list) {
													int i = 0;
										%>
										<option value="blank" disabled selected>(Policy
											Name-Type-Agent-Date Sold)</option>
										<option
											value="<%=l.get(0)%>/<%=l.get(5)%>/<%=l.get(6)%>/<%=l.get(7)%>/<%=l.get(8)%>/<%=l.get(4)%>">
											<%
												for (i = 1; i < 4; i++) {
											%>
											<%=l.get(i)%>-<%
												}
											%>-<%=l.get(i)%></option>
										<%
											}
										%>
									</select>

								</div>

								<button type="submit" class="btn">Select this policy!</button>
						</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	</div>
	<%
		}
	%>




</body>
</html>