<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payments</title>
<script type="text/javascript">
	 window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<script>
	function hidestatus() {
		window.status = ''
		return true
	}

	if (document.layers)
		document.captureEvents(Event.MOUSEOVER | Event.MOUSEOUT)

	document.onmouseover = hidestatus
	document.onmouseout = hidestatus
</script>
</head>
<body background="resources\light-blue-background.jpg"
	onload="noBack();"     onpageshow="if (event.persisted) noBack();"
	 onunload="">
	<form action="..\UserRequestHandler" method="post">
	<input type="hidden" name="action" value="payment2">
		<%
			String val = request.getParameter("values");
			String[] value = val.split("/");
			int transId = Integer.valueOf(value[0]);
			int TotalTime = Integer.valueOf(value[1]);
			int PremiumPaid = Integer.valueOf(value[2]);
			int PayMode = Integer.valueOf(value[3]);
			double Total = Double.valueOf(value[4]);
			double premium = (Total / TotalTime) * PayMode;
			String mode;
			if (PayMode == 1)
				mode = "Monthly";
			else if (PayMode == 3)
				mode = "Quaterly";
			else if (PayMode == 6)
				mode = "Half-Yearly";
			else
				mode = "Annualy";
			Date d = Date.valueOf(value[5]);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MONTH, (PremiumPaid + PayMode));

			String[] due = ((new Date(c.getTimeInMillis())).toString())
					.split("-");
			String dueDate = due[2] + "/" + due[1] + "/" + due[0];
			String date[] = value[5].split("-");
			String StartDate = date[2] + "/" + date[1] + "/" + date[0];
			c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.MONTH, TotalTime);
			String[] last = ((new Date(c.getTimeInMillis())).toString())
					.split("-");
			String lastDate = last[2] + "/" + last[1] + "/" + last[0];
			List<Object> list = new ArrayList<Object>();
			list.add(transId);
			list.add(Total);
			list.add(TotalTime);

			list.add(StartDate);
			list.add(lastDate);
			list.add(mode);
			list.add(PremiumPaid);

			list.add(dueDate);
			list.add(premium);
		%>
		<input name="TransactId" value="<%=list.get(0)%>" type="hidden">
		<input name="payAmount" value="<%=list.get(8)%>" type="hidden">
		<table align="center" style="padding-top: 100px" cellpadding="10"
			cellspacing="10">
			<tr>
				<th>Total Amount Payble:</th>
				<td><%=list.get(1)%></td>
			</tr>
			<tr>
				<th>Policy Duration:</th>
				<td><%=list.get(2)%></td>
			</tr>
			<tr>
				<th>Policy Start Date:</th>
				<td><%=list.get(3)%></td>
			</tr>
			<tr>
				<th>Policy Completion Date:</th>
				<td><%=list.get(4)%></td>
			</tr>
			<tr>
				<th>Premium Mode Selected:</th>
				<td><%=list.get(5)%></td>
			</tr>
			<tr>
				<th>Premium Paid In months:</th>
				<td><%=list.get(6)%></td>
			</tr>
		</table>
		<table align="center" style="padding-top: 120px" cellpadding="10"
			cellspacing="10">
			<tr>
				<th>Due Date:</th>
				<td><%=list.get(7)%></td>
			</tr>
			<tr>
				<th>Payble Amount:</th>
				<td><%=list.get(8)%></td>
			</tr>
		</table>

		<p align="center">
			<button type="submit" style="background-color: aqua;">Pay!</button>
		</p>
	</form>
</body>
</html>