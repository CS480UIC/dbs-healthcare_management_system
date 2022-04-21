<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Delete Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/InsuranceServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="insurance_id" value="${insurance.insurance_id }"/>
	Insurance ID	        ：<input type="text" name="insurance_id" value="${insurance.insurance_id }"/>
	<span style="color: red; font-weight: 900">${errors.insurance_id }</span>
	<br/>
	Insurance Company  :<input type="text" name="insurance_company" value="${insurance.insurance_company }"/>
	<span style="color: red; font-weight: 900">${errors.insurance_company }</span>
	<br/>
	
	Start date ：<input type="text" name="start_date" value="${insurance.start_date }"/>
	<span style="color: red; font-weight: 900">${errors.start_date }</span>
	<br/>
	End date：<input type="text" name="end_date" value="${insurance.end_date }"/>
	<span style="color: red; font-weight: 900">${errors.end_date }</span>
	<br/>
	Insurance Plan ：<input type="text" name="insurance_plan" value="${insurance.insurance_plan }"/>
	<span style="color: red; font-weight: 900">${errors.insurance_plan }</span>
	<br/>
	Patient ID ：<input type="text" name="patient_id" value="${insurance.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	<input type="submit" value="Delete Insurance"/>
</form>

</body>
</html>
