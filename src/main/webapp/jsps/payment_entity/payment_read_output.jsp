<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Entity Output</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Read Doctor Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	Payment ID	        ：<input type="text" name="payment_id" value="${payment.payment_id }"/>
	<span style="color: red; font-weight: 900">${errors.payment_id }</span>
	<br/>
	First Name  :<input type="text" name="first_name" value="${payment.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	Last Name   ：<input type="password" name="last_name" value="${payment.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	Payment Type       ：<input type="text" name="type_of_payment" value="${payment.type_of_payment }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	
	Doctor Referred	：<input type="text" name="doc_referred" value="${payment.doc_referred }"/>
	<span style="color: red; font-weight: 900">${errors.doc_referred }</span>
	<br/>
	Date	：<input type="text" name="date" value="${payment.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	Treatment	    ：<input type="text" name="treatment" value="${payment.treatment }"/>
	<span style="color: red; font-weight: 900">${errors.treatment }</span>
	<br/>
	Patient ID	        ：<input type="text" name="patient_id" value="${payment.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
