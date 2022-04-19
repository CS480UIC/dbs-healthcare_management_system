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
  <h1>Read Patient Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	Patient_ID	        ：<input type="text" name="patient_id" value="${patient.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	First Name  :<input type="text" name="first_name" value="${patient.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	Last Name   ：<input type="text" name="last_name" value="${patient.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	Contact	    ：<input type="text" name="contact_no" value="${patient.contact_no }"/>
	<span style="color: red; font-weight: 900">${errors.contact_no }</span>
	<br/>
	Email       ：<input type="text" name="email" value="${patient.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Gender	：<input type="text" name="gender" value="${patient.gender }"/>
	<span style="color: red; font-weight: 900">${errors.gender }</span>
	<br/>
	Age	：<input type="text" name="age" value="${patient.age }"/>
	<span style="color: red; font-weight: 900">${errors.age }</span>
	<br/>
	UserName	    ：<input type="text" name="user_name" value="${patient.user_name }"/>
	<span style="color: red; font-weight: 900">${errors.user_name }</span>
	<br/>
	Password    ：<input type="text" name="password" value="${patient.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Hospital_ID	        ：<input type="text" name="hospital_id" value="${patient.hospital_id }"/>
	<span style="color: red; font-weight: 900">${errors.hospital_id }</span>
	<br/>
	Doctor_ID	        ：<input type="text" name="doctor_id" value="${patient.doctor_id }"/>
	<span style="color: red; font-weight: 900">${errors.doctor_id }</span>
	<br/>
	
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
