<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit Cheque</title>
</head>
<body>
<h3>Cheque Deposit:</h3>
	<s:form action="banking/chequeDeposit.action" >
		<s:textfield name="to_acc_no" label="To Account No"/>
		<s:textfield name="cheque_date" label="Cheque Date"/>
		<s:textfield name="b_details" label="Bank Details"/>
		<s:textfield name="cheque_no" label="Cheque No"/>
		<s:textfield name="amount" label="Amount:"/>
		<s:submit value="Submit" />
	</s:form>
</body>
</html>