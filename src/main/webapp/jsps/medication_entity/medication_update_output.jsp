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
	Medicine ID	        ：<input type="text" name="medicine_id" value="${medication.medicine_id }"/>
	<span style="color: red; font-weight: 900">${errors.medicine_id }</span>
	<br/>
	Medicine Name  :<input type="text" name="medicine_name" value="${medication.medicine_name }"/>
	<span style="color: red; font-weight: 900">${errors.medicine_name }</span>
	<br/>
	
	Price      ：<input type="text" name="price" value="${medication.price }"/>
	<span style="color: red; font-weight: 900">${errors.price }</span>
	<br/>
	Manufacture date ：<input type="text" name="mfg_date" value="${medication.mfg_date }"/>
	<span style="color: red; font-weight: 900">${errors.mfg_date }</span>
	<br/>
	Expiry date：<input type="text" name="exp_date" value="${medication.exp_date }"/>
	<span style="color: red; font-weight: 900">${errors.exp_date }</span>
	<br/>
	Company ：<input type="text" name="mfg_company" value="${medication.mfg_company }"/>
	<span style="color: red; font-weight: 900">${errors.mfg_company }</span>
	<br/>
	Doctor ID ：<input type="text" name="doctor_id" value="${medication.doctor_id }"/>
	<span style="color: red; font-weight: 900">${errors.doctor_id }</span>
	<br/>
	Patient ID ：<input type="text" name="patient_id" value="${medication.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/MedicationServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="medicine_id" value="${medication.medicine_id }"/>
		<br/>
	
	Medicine Name  :<input type="text" name="medicine_name" value="${medication.medicine_name }"/>
	<span style="color: red; font-weight: 900">${errors.medicine_name }</span>
	<br/>
	
	Price      ：<input type="text" name="price" value="${medication.price }"/>
	<span style="color: red; font-weight: 900">${errors.price }</span>
	<br/>
	Manufacture date ：<input type="text" name="mfg_date" value="${medication.mfg_date }"/>
	<span style="color: red; font-weight: 900">${errors.mfg_date }</span>
	<br/>
	Expiry date：<input type="text" name="exp_date" value="${medication.exp_date }"/>
	<span style="color: red; font-weight: 900">${errors.exp_date }</span>
	<br/>
	Company ：<input type="text" name="mfg_company" value="${medication.mfg_company }"/>
	<span style="color: red; font-weight: 900">${errors.mfg_company }</span>
	<br/>
	Doctor ID ：<input type="text" name="doctor_id" value="${medication.doctor_id }"/>
	<span style="color: red; font-weight: 900">${errors.doctor_id }</span>
	<br/>
	Patient ID ：<input type="text" name="patient_id" value="${medication.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	
	<input type="submit" value="Update Medication"/>
</form>

</body>
</html>
