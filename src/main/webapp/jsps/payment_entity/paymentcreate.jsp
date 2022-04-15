<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Payment Entity Create</title>
    
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
  <h1>Payment Entity Create</h1>
   
		
<form action="<c:url value='/PaymentServletCreate'/>" method="post">
    Payment ID	        ：<input type="text" name="payment_id" value="${form.payment_id }"/>
	<span style="color: red; font-weight: 900">${errors.payment_id }</span>
	<br/>
	First Name  :<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	Last Name   ：<input type="password" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	Payment Type       ：<input type="text" name="type_of_payment" value="${form.type_of_payment }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	
	Doctor Referred	：<input type="text" name="doc_referred" value="${form.doc_referred }"/>
	<span style="color: red; font-weight: 900">${errors.doc_referred }</span>
	<br/>
	Date	：<input type="text" name="date" value="${form.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	Treatment	    ：<input type="text" name="treatment" value="${form.treatment }"/>
	<span style="color: red; font-weight: 900">${errors.treatment }</span>
	<br/>
	Patient ID	        ：<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	
	
	
	
	
	<input type="submit" value="Create Payment"/>
	
</form>
  </body>
</html>
