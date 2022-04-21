<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: ORANGE; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">HEALTH CARE MANAGEMENT SYSTEM</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; 
			<a href="<c:url value='/jsps/initialize/init.jsp'/>" target="body">Initialize Database</a> |&nbsp;&nbsp;
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/doctor_entity/menu.jsp'/>" target="body">Doctor Entity </a> |&nbsp;&nbsp;
            <a href="<c:url value='/jsps/payment_entity/menu.jsp'/>" target="body">Payment Entity </a> |&nbsp;&nbsp;
		    <a href="<c:url value='/jsps/medication_entity/menu.jsp'/>" target="body">Medication Entity </a> |&nbsp;&nbsp;
		    <a href="<c:url value='/jsps/hospital_entity/menu.jsp'/>" target="body">Hospital Entity </a> |&nbsp;&nbsp;
            <a href="<c:url value='/jsps/insurance_entity/menu.jsp'/>" target="body">Insurance Entity </a> |&nbsp;&nbsp;
		    <a href="<c:url value='/jsps/patient_medication_entity/menu.jsp'/>" target="body">Patient Medication Entity </a> |&nbsp;&nbsp;
		    <a href="<c:url value='/jsps/patient_entity/menu.jsp'/>" target="body">Patient Entity </a> |&nbsp;&nbsp;
            <a href="<c:url value='/jsps/patient_medical_history_surgeries_entity/menu.jsp'/>" target="body">Patient Surgeries Entity </a> |&nbsp;&nbsp;
		    <a href="<c:url value='/jsps/patient_medical_history_entity/menu.jsp'/>" target="body">Patient Medical History Entity </a> |&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

