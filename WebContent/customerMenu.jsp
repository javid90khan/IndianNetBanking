<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome 
<s:property value="#session.username"/>&nbsp; Account Number:<s:property value="#session.acc_no"/> &nbsp;<a href="banking/selectAccountAction">&lt;&lt;Switch Account</a><br /><a href="banking/logout">Logout</a>
<br />
<MARQUEE><h3>**Customer MENU**</h3></MARQUEE>
	<ul>
	
	<li><h4><a href="banking/showBalance.action">Check Balance</a></h4></li>
	<li><h4><a href="banking/showBankStatement.action">Bank Statement</a></h4></li>
	<li><h4><a href="<%= request.getContextPath() %>/fundTransfer.jsp">Fund Transfer</a></h4></li>
	<li><h4><a href="<%= request.getContextPath() %>/chequeBookRequest.jsp">Request Chequebook</a></h4></li>
	
	</ul>
</body>
</html>