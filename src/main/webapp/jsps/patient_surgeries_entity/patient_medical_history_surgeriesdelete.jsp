<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Patient Surgeries Delete</title>
    
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
  <h1>Delete Patient Surgeries</h1>
<form action="<c:url value='/Patient_medical_history_surgeriesServletDelete'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Delete Patient Surgeries   :<input type="text" name="username" value="${form.history_id }"/>
	<span style="color: red; font-weight: 900">${errors.history_id }</span>
	<br/>
	<input type="submit" value="Delete Patient Surgeries "/>
</form>
  </body>
</html>
