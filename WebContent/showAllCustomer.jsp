<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="banking/resultAction" >
 
<h4>
<s:select label="Account Type"  headerKey="-1"
                        headerValue="Select Account" list="acc_nos"
                        name="acc_type" />	
</h4>
 
<s:submit value="submit" name="submit" />
 
</s:form>
 
</body>
</html>