<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="AgentForm/assets/css/style.css">

<title>ViewPolicySold</title>
</head>
<body background="..\resources\light-blue-background.jpg">
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="agentHome.jsp" style="color: black">WELCOME
					USER </a></li>
			<li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<div class="container-fluid text-center">
		<h2>Policy Sold</h2>
	</div>
	<br>
	<%
		List<List<Object>> list = new ArrayList<List<Object>>();
		list = (List<List<Object>>) request
				.getAttribute("viewPolicyDetails");
		Iterator<List<Object>> itr = list.iterator();
		int size = list.size();
		int flag = 0;
		String message = "You have sold no Policy Yet";
		if (size == 0) {
			flag = 1;
		}
		if (flag != 1) {
	%>
	<table class="table" border="1" bordercolor="grey"
		style="width: 900px; padding-top: 1000px;" align="center">
		<thead>
			<tr>
				<th>Policy Name</th>
				<th>Policy type</th>
				<th>Policy Holder</th>
				<th>Selling Date</th>
				<th>Premium Mode</th>
				<th>Duration</th>
				<th>Months premium paid</th>
			</tr>
		</thead>

		<%
			List<Object> list1;
				while (itr.hasNext()) {
					list1 = new ArrayList<Object>();
					list1 = itr.next();
		%>
		<tbody>
			<tr>
				<%
					for (Object s : list1) {
				%>
				<td><%=s%></td>
				<%
					}
				%>
			</tr>
		</tbody>
		<%
			}
		%>
	</table>
	<%
		}
	%>
	<%
		if (flag == 1) {
	%>
	<%=message%>
	<%
		}
	%>
</body>
</html>