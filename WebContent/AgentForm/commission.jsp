<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Commission</title>
<link rel="stylesheet"
	href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="AgentForm/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="..\Templates.css">
<link rel="stylesheet" type="text/css" href="Agentcss.css">

<link rel="stylesheet" type="text/css" href="..\Templates.css">
</head>
<body>
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="gentHome.jsp" style="color: black">WELCOME USER
			</a></li>
			<li><a href="home.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<br>
	<br>
	<center>
		<h1>Commission-Table</h1>
	</center>
	<%
		List<List<Object>> list = new ArrayList<List<Object>>();
		list = (List<List<Object>>) request.getAttribute("CommissionList");

		Integer totalCom = 0;
		Integer i;
		int count = 0;
		String s = "Sorry No Policy Sold Till";
		int j = list.size();
		int f = 0;
	%><br>

	<%
		if (j == 0)
			f = 1;
	%>
	<%
		if (f == 0) {
	%>

	<table class="table" style="width: 500px" align="center">
		<thead>
			<tr>
				<th><b>Policy Names </b></th>
				<th><b>Policy Holder</b></th>
				<th><b>Date Sold</b></th>
				<th><b>Commission</b></th>
			</tr>
		</thead>

		<%
			Iterator<List<Object>> it = list.iterator();

				while (it.hasNext()) {
					Iterator<Object> itr = it.next().iterator();
		%><tbody>
			<tr>
				<%
					while (itr.hasNext()) {
								Object val = itr.next();
				%>

				<td><%=val%></td>
				<%
					count++;
								if (count == 4) {
									totalCom = totalCom + (Integer) val;
									count = 0;
								}
				%>

				<%
					}
				%>
			</tr>
		</tbody>
		<%
			}
		%>
		<tr>
			<td>Total:</td>
			<td></td>
			<td></td>
			<td><%=totalCom%></td>
	</table>
	<%
		}
	%>

	<%
		if (f == 1) {
	%><%=s%>
	<%
		}
	%>

</body>
</html>