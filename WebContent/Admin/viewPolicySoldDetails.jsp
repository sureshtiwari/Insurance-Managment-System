<%@page import="aricent.project.model.modelclasses.PolicySold"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="AgentForm/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="AgentForm/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="AgentForm/assets/css/form-elements.css">
        <link rel="stylesheet" href="AgentForm/assets/css/style.css">
         <link rel="stylesheet" href="Templates.css">
        
	
<title>ViewPolicySold </title>
</head>
<body background="resources\light-blue-background.jpg">
<header>

    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Admin/adminHome.jsp" style="color: black">WELCOME USER </a></li>
        <li><a href="logout.jsp" style="color: black">LOGOUT</a></li>
      </ul>
    
    </div>
</header>
<div class="container-fluid text-center">
  <h2><b>PolicySold Details</b></h2> </div>
  <br>
  <% List<PolicySold> list=(List<PolicySold>)request.getAttribute("viewPolicySold");
int size=list.size();
 int flag=0;
 String message= "No data found";
 if(size==0){
	 flag=1;
 }
 if(flag!=1){%>
<table style="" align="center" cellpadding="10" cellspacing="100">
<tr>
<th width="200">UserID</th>
<th width="200">AgentID</th>
<th width="200">PolicyID</th>
<th width="200">StartDate</th>
</tr>
<%
for(PolicySold policysold:list) {%>
<tr>
<td align="left"><%=policysold.getUserID() %>
<td align="left">
<%=policysold.getAgentID()%></td>
<td align="left"><%=policysold.getPolicyID()%></td>
<td align="left">
<%String[] date=(policysold.getStartDate().toString()).split(" ");
 String[] dob=date[0].split("-");
%><%=dob[2]+"/"+dob[1]+"/"+dob[0] %></td>
</tr>
	
<%} }%>
</table>
<%if(flag==1){%>
	<%=message %>
<%}%>
	
	
</body>
</html>


