<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Patient Medical History Entity Create</title>
    
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
  <h1>Patient Medical History Entity Create</h1>
<form action="<c:url value='/PatientMedicalHistoryServletCreate'/>" method="post">

	History ID	        ：<input type="text" name="history_id" value="${form.history_id }"/>
	<span style="color: red; font-weight: 900">${errors.history_id }</span>
	<br/>
	Conditions  :<input type="text" name="conditions" value="${form.conditions }"/>
	<span style="color: red; font-weight: 900">${errors.conditions }</span>
	<br/>
	
	
	Last Visit：<input type="text" name="last_visit" value="${form.last_visit }"/>
	<span style="color: red; font-weight: 900">${errors.last_visit }</span>
	<br/>
	
	Patient ID ：<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	
	
	
	
	
	
	<input type="submit" value="Create Patient Medical History"/>
	
</form>
  </body>
</html>
