<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Statement</title>
</head>
<body>
<h3>Bank Statement:</h3>




<table border="1">
<tr>
<td>Transaction ID</td>
<td>Transaction Date</td>
<td>Credit</td>
<td>Debit</td>
<td>Description</td>

<s:iterator value="transactions">
<tr> 
<td><s:property value="tid" /></td>
<td><s:property value="tdate"/></td>
<td><s:property value="credit"/></td>
<td><s:property value="debit"/></td>
<td><s:property value="description"/></td>
</tr>
	
</s:iterator>
</table>
<hr>
<a href="<%= request.getContextPath() %>/customerMenu.jsp">&lt;&lt;Home</a>
</body>
</html>