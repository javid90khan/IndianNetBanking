<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>




	<div class="content">
	<h1 align="center">Indian Net Banking</h1>
	<br />
		<s:form action="banking/login.action" cssClass="bootstrap-frm">
    <h1>Login </h1>
 
   
    <label>Username :</label>
        <input  type="text" name="username"  />
    
    
    <label>Password:</label>
        <input  type="password" name="password"  />

        <span>&nbsp;</span> 
        <s:submit value="Login" cssClass="button" /> 
        
</s:form>

</div>
			
</body>
</html>