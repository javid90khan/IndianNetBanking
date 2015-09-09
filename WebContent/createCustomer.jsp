<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Customer</title>
</head>
<body>
<h3>Create Customer:</h3>
<s:form action="banking/createCustomer.action" >
	
			<s:textfield name="firstname" label="firstname"/>
			<s:textfield name="lastname" label="lastname"/>
			<s:textfield name="dob" label="dob"/>
			<s:textfield name="address" label="address"/>
			<s:textfield name="mobile" label="mobile"/>
			<s:submit value="submit"/>
		
	</s:form>
</body>
</html>