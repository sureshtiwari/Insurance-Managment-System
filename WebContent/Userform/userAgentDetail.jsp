<%@page import="aricent.project.model.modelclasses.Agent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agent Details</title>
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
<link rel="stylesheet" href="AgentForm/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="Templates.css">
</head>
<body>
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="AgentHome.html" style="color: black">WELCOME
					USER </a></li>
			<li><a href="../logout.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<centre>
	<h1>Agent Details</h1>
	</centre>
	<%
		List<Agent> list = new ArrayList<Agent>();
		HashMap<Integer, Agent> hm = new HashMap<Integer, Agent>();
		List<Integer> list3 = new ArrayList<Integer>();
	%>
	<%
		list = (List<Agent>) request.getAttribute("viewAgents");
		int count = 0;
	%>
	<table class="table" style="padding-top: 300px" align="center"
		cellspacing="300" cellpadding="10">
		<tr>
			<th style="width: 200px"><b>Agent Name </b></th>
			<th width="200"><b>Date-Of-Birth</b></th>
			<th width="200"><b>Phone Number</b></th>
			<th width="200"><b>E-mail</b></th>
			<th width="200"><b>Address</b></th>
		</tr>
		<%
			Iterator<Agent> it = list.iterator();
			while (it.hasNext()) {
				Agent p = (Agent) it.next();
				list3.add((Integer) p.getAgentID());
		%>
		<%
			hm.put(p.getAgentID(), p);
		%>

		<%
			}
		%>
		<%
			for (Map.Entry m : hm.entrySet()) {
				Agent p = (Agent) m.getValue();
		%>

		<tr>
			<td align="left"><%=p.getName()%></td>
			<td align="left">
				<%
					String[] d = (p.getDob().toString()).split(" ");
						String[] date = d[0].split("-");
				%><%=date[2] + "/" + date[1] + "/" + date[0]%></td>

			<td align="left"><%=p.getPhoneNumber()%></td>
			<td align="left"><%=p.getEmail()%></td>
			<td align="left"><%=p.getAddress()%></td>
		</tr>

		<%
			}
		%>

	</table>
</body>
</html>