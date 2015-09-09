<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Balance</title>
</head>
<body>
<h3>Balance:</h3>
Account Balance:<s:label value="%{balance}"/>
<hr>
<a href="<%= request.getContextPath() %>/customerMenu.jsp">&lt;&lt;Home</a>
</body>
</html>