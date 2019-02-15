<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policy status</title>
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
<body>
	<header>

	<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="agentHome.jsp" style="color: black">WELCOME
					USER </a></li>
			<li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
		</ul>

	</div>
	</header>
	<table class="table" border="1" bordercolor="grey"
		style="width: 900px; padding-top: 1000px;" align="center">
		<thead>
			<tr>
				<th>Policy Name</th>
				<th>Policy type</th>
				<th>Name of agent</th>
				<th>Premium Mode</th>
				<th>Duration</th>
				<th>Months Paid</th>
				<th>Start Date</th>
			</tr>
		</thead>
		<%
			List<List<Object>> list = new ArrayList<List<Object>>();
			list = (List<List<Object>>) request.getAttribute("policystaus");
			Iterator<List<Object>> itr = list.iterator();
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
</body>
</html>