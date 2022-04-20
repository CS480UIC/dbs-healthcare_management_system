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
  <h1>Read Hospital Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	Hospital_ID	  ：<input type="text" name="hospital_id" value="${hospital.hospital_id }"/>
	<span style="color: red; font-weight: 900">${errors.hospital_id }</span>
	<br/>
	Name  :<input type="text" name="first_name" value="${hospital.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	Address	    ：<input type="text" name="address" value="${hospital.address }"/>
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	Phone	    ：<input type="text" name="contact_no" value="${hospital.contact_no }"/>
	<span style="color: red; font-weight: 900">${errors.contact_no }</span>
	<br/>
	Email       ：<input type="text" name="email" value="${hospital.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	
	Employee Count	：<input type="text" name="experience" value="${hospital.employee_count }"/>
	<span style="color: red; font-weight: 900">${errors.employee_count }</span>
	<br/>
	
	
	
	
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
