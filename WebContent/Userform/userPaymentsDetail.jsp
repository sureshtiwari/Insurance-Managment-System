
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
<link rel="stylesheet" type="text/css" href="..\Templates.css">
<link rel="stylesheet" type="text/css"
	href="..\bootstrap-3.3.6-dist\css\bootstrap.css">
<title>Payment Details</title>

</head>
<body>
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="../userHome.jsp" style="color: black">HOME </a></li>
			<li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<center>
		<h1>
			<strong>Payment Details</strong>
		</h1>
	</center>
	<%
		List<List<Object>> list = new ArrayList<List<Object>>();
		list = (List<List<Object>>) request.getAttribute("list");
		Iterator<List<Object>> itr = list.iterator();
		int size = list.size();
		int flag = 0;
		String message = "No Payment Found";
		if (size == 0) {
			flag = 1;
		}
		if (flag == 0) {
	%>
	<table class="table" border="1" bordercolor="grey"
		style="width: 900px;" align="center">
		<thead>
			<tr>
				<th align="center">Policy Name</th>
				<th align="center">Policy type</th>
				<th align="center">Payment Date</th>
				<th align="center">Amount</th>
			</tr>
		</thead>

		<%
			for (List<Object> list1 : list) {
		%>
		<tbody>
			<tr>
				<%
					for (Object s : list1) {
				%>
				<td align="left"><%=s%></td>
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
	<center>
		<h3>
			<strong><%=message%></strong>
		</h3>
	</center>
	<%
		}
	%>

</body>
</html>