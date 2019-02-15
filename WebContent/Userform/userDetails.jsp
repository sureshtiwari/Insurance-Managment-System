
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validation.js"> </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Information</title>
<link rel="stylesheet" href="Userform/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="Userform/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="Userform/assets/css/form-elements.css">
<link rel="stylesheet" href="Userform/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="Templates.css">
<link rel="stylesheet" type="text/css" href="AgentForm\Agentcss.css">

<link rel="stylesheet" type="text/css" href="Templates.css">
<style>
.user-row {
	margin-bottom: 14px;
}

.user-row:last-child {
	margin-bottom: 0;
}

.dropdown-user {
	margin: 13px 0;
	padding: 5px;
	height: 100%;
}

.dropdown-user:hover {
	cursor: pointer;
}

.table-user-information>tbody>tr {
	border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information>tbody>tr:first-child {
	border-top: 0;
}

.table-user-information>tbody>tr>td {
	border-top: 0;
}

.toppad {
	margin-top: 20px;
}
</style>
</head>
<body>

	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/AgentForm/agentHome.jsp" style="color: black">WELCOME
					USER </a></li>
			<li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<center>
		<h1>Update-Information</h1>
	</center>
	<br>
	<%
		List<Object> list = new ArrayList<Object>();
		list = (List<Object>) request.getAttribute("Details");
	%><center>

		<form action="UserRequestHandler" method="post" onsubmit="return updateValidate(document.getElementById('name').value,document.getElementById('number').value,document.getElementById('address').value,document.getElementById('city').value,document.getElementById('state').value,document.getElementById('zip').value)">
			<table width="200px" style="text-align: left;">
				<input type="hidden" name="action" value="updateDetails">
				<tr>
					<td style="width: 50px;"><b>Name :</b></td>
					<td><input type="text" align="left" name="name" id="name" onblur="nameValidate(document.getElementById('name').value)"
						value="<%=list.get(0)%>"></td>
					<td><span class="glyphicon glyphicon-pencil"></span></td>
				</tr>
				<tr>
					<td><b>Date_Of_Birth: </b></td>
					<td><input type="text" align="left" name="dob"
						value="<%=list.get(1)%>" readonly></td>

				</tr>

				<tr>
					<td><b>Phone No.: </b></td>
					<td><input type="text" align="left" name="number" id="number" onblur="mobileNumberValidate(document.getElementById('number').value)"
						value="<%=list.get(2)%>"></td>
					<td><span class="glyphicon glyphicon-pencil"></span></td>
				</tr>

				<tr>
					<td><b>E-mail:</b></td>
					<td><input type="text" align="left" name="email"
						value="<%=list.get(3)%>" readonly></td>
				</tr>

				<tr>
					<td style="width: 100px;"><b>Father's Name: </td>
					<td><input type="text" align="left" name="fathersname"
						value=" <%=list.get(4)%>" readonly></td>
				</tr>

				<tr>
					<td><b>Address :</b></td>
					<td><textarea rows="4" cols="50" name="address" id="address" onblur="addressValidate(document.getElementById('address').value)"><%=list.get(5)%></textarea></td>
					<td><span class="glyphicon glyphicon-pencil"></span></td>
				</tr>

				<tr>
					<td><b>City :</b></td>
					<td><input type="text" name="city" align="left" id="city" onblur="cityValidate(document.getElementById('city').value)"
						value="<%=list.get(6)%>"></td>
					<td><span class="glyphicon glyphicon-pencil"></span></td>
				</tr>

				<tr>
					<td><b>State :</b></td>
					<td><input type="text" name="state" align="left" id="state" onblur="stateValidate(document.getElementById('state').value)"
						value="<%=list.get(7)%>"></td>
					<td><span class="glyphicon glyphicon-pencil"></span></td>
				</tr>

				<tr>
					<td><b>Zip Code :</b></td>
					<td><input type="text" name="zip" align="left" id="zip" onblur="zipValidate(document.getElementById('zip').value)" value="<%=list.get(8)%>"></td>
					<td><span class="glyphicon glyphicon-pencil"></span></td>
				</tr>

			</table>
			<br>
			<br>

			<center>
				<input type="submit" value="Submit">
			</center>

		</form>



	</center>
</body>


</html>