<%@page import="aricent.project.model.modelclasses.PolicyHolder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View PolicyHolder Details</title>
<link rel="stylesheet"
	href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="AgentForm/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="Templates.css">
<link rel="stylesheet" type="text/css" href="AgentForm/Agentcss.css">

<link rel="stylesheet" type="text/css" href="Templates.css">
</head>
<body>
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="AgentHome.html" style="color: black">WELCOME
					USER </a></li>
			<li><a href="../HomePage.html" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<br>
	<br>
	<centre>
	<h1>Policy-Holder Details</h1>
	</centre>
	<%
		List<PolicyHolder> list = new ArrayList<PolicyHolder>();
		HashMap<Integer, PolicyHolder> hm = new HashMap<Integer, PolicyHolder>();
		List<Integer> list3 = new ArrayList<Integer>();
	%>
	<%
		list = (List<PolicyHolder>) request.getAttribute("users");
		int count = 0;
		int flag = 0;
		int size = list.size();
		String message = "No Users found...You are not added any Policy Holders";
		if (size == 0) {
			flag = 1;
		}
		if (flag == 0) {
	%>
	<table class="table" style="width: 500px" align="center" width="1000">
		<thead>
			<tr>
				<th><b>PolicyHolder Name </b></th>
				<th><b>Address</b></th>
				<th><b>Phone Number</b></th>
				<th><b>E-mail</b></th>
				<th style="width: 400px"><b>Date-Of-Birth</b></th>
			</tr>
		</thead>
		<%
			Iterator<PolicyHolder> it = list.iterator();
				while (it.hasNext()) {
					PolicyHolder p = (PolicyHolder) it.next();
					list3.add((Integer) p.getUserID());
		%>
		<%
			hm.put(p.getUserID(), p);
		%>

		<%
			}
		%>
		<%
			for (Map.Entry m : hm.entrySet()) {
					PolicyHolder p = (PolicyHolder) m.getValue();
		%>

		<tr>
			<td><%=p.getName()%></td>
			<td><%=p.getAddress()%></td>
			<td><%=p.getPhoneNumber()%></td>
			<td><%=p.getEmail()%></td>
			<td><%=p.getDob()%></td>
		</tr>

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