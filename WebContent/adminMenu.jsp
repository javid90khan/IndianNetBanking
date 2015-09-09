<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Menu</title>
</head>

<body>

<s:div cssClass="content">
	<h1 align="center">Indian Net Banking</h1>
	<br />

<label class="rightLable">Welcome 
<s:property value="#session.username"/> &nbsp;<a href="banking/logout">Logout</a></label>
<br />
<s:div cssClass="bootstrap-frm">
<h1>Admin Menu</h1>
	<ul>
	<li><h4><a href="<%= request.getContextPath() %>/createCustomer.jsp">Create Customer</a></h4></li>
	<li><h4><a href="<%= request.getContextPath() %>/createAccount.jsp">Create Account</a></h4></li>
	<li><h4><a href="<%= request.getContextPath() %>/chequeDeposit.jsp">Cheque Deposit</a></h4></li>
	<li><h4><a href="banking/showPendingCheques.action">Pending Cheques</a></h4></li>
	<li><h4><a href="<%= request.getContextPath() %>/pendingChequeBookRequests.jsp">Pending Cheque Book Request</a></h4></li>
	</ul>
	</s:div>
</s:div>
</body>
</html>