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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	Patient_ID	        ：<input type="text" name="patient_id" value="${patient.patient_id }" disabled/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	First Name  :<input type="text" name="first_name" value="${patient.first_name }" disabled/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	Last Name   ：<input type="text" name="last_name" value="${patient.last_name }" disabled/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	Contact	    ：<input type="text" name="contact_no" value="${patient.contact_no }" disabled/>
	<span style="color: red; font-weight: 900">${errors.contact_no }</span>
	<br/>
	Email       ：<input type="text" name="email" value="${patient.email }" disabled/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Gender	：<input type="text" name="gender" value="${patient.gender }" disabled/>
	<span style="color: red; font-weight: 900">${errors.gender }</span>
	<br/>
	Age	：<input type="text" name="age" value="${patient.age }" disabled/>
	<span style="color: red; font-weight: 900">${errors.age }</span>
	<br/>
	UserName	    ：<input type="text" name="user_name" value="${patient.user_name }" disabled/>
	<span style="color: red; font-weight: 900">${errors.user_name }</span>
	<br/>
	Password    ：<input type="text" name="password" value="${patient.password }" disabled/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Hospital_ID	        ：<input type="text" name="hospital_id" value="${patient.hospital_id }" disabled/>
	<span style="color: red; font-weight: 900">${errors.hospital_id }</span>
	<br/>
	Doctor_ID	        ：<input type="text" name="doctor_id" value="${patient.doctor_id }" disabled/>
	<span style="color: red; font-weight: 900">${errors.doctor_id }</span>
	<br/>
	
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/PatientServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="patient_id" value="${patient.patient_id }"/>
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
	
	<input type="submit" value="Update Patient"/>
</form>

</body>
</html>
