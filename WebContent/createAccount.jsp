<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<h3>Create Account:</h3>
<s:form action="banking/createAccount.action">

<table>
	
	<tr>
		<td><s:textfield name="custId" label="Customer ID"></s:textfield></td>
	</tr>
	<tr>
		<td><s:select label="Account Type"  headerKey="-1"
                        headerValue="Select Account Type" list="# {'Current':'Current', 'Saving':'Saving'}"
                        name="acc_type" />
		<td><s:textfield name="balance" label="Balance"></s:textfield></td>
	</tr>
	
	<tr>
		<td><s:submit value="Create Account"/></td>
	</tr>
</table>

</s:form>

</body>
</html>