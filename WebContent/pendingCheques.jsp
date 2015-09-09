<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending Cheques</title>
</head>
<body>
<h3>Pending Cheques:</h3>
<s:form action="banking/approveCheques.action">

<table border="1" class="wwFormTable">
	<tr>
		<td>Cheque Id</td>
		<td>Cheque Date</td>
		<td>Cheque Details</td>
		<td>Cheque Number</td>
		<td>Amount</td>
		<td>Deposit Date</td>
		<td>Account Number</td>
		<td>Status</td>
	</tr>

<s:iterator value="cheques">
	<tr> 
		<td><s:property value="cheque_id" /></td>
		<td><s:property value="cheque_date"/></td>
		<td><s:property value="b_details"/></td>
		<td><s:property value="cheque_no"/></td>
		<td><s:property value="amount"/></td>
		<td><s:property value="dep_date"/></td>
		<td><s:property value="to_acc_no"/></td>
		<td><s:property value="status"/></td>
	 </tr>
</s:iterator>
	 
<tr><td colspan="8"><s:checkboxlist label="Select Cheque IDs For Approval(id-acc_no-amount)" list="chequeIds" 
	   name="selectedChequeIds" /><s:submit value="Approve Selected" /></td></tr>
</table>
</s:form>
</body>
</html>