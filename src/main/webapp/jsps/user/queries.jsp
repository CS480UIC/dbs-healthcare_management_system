<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
      </br>
    <a href="<c:url value='/findDoctors'/>" target="body">Please list all the doctors</a>&nbsp;&nbsp;
      </br>
    <a href="<c:url value='/findPatients'/>" target="body">Please list all the patients</a>&nbsp;&nbsp;
   </br>
    <a href="<c:url value='/findHospitals'/>" target="body">Please list all the hospitals with more than 50 employee</a>&nbsp;&nbsp;
          </br>
    <a href="<c:url value='/findPatientsD'/>" target="body">Please list all the patients</a>&nbsp;&nbsp;
    </br>
    <a href="<c:url value='/findDoctorsH'/>" target="body">Please list all the patients</a>&nbsp;&nbsp;
    <br>
    <a>Aggregate Queries</a>
    </br>
    <a href="<c:url value='/findTotalPrice'/>" target="body">Please list all the total Price of Medicines manufactured by TCS Company</a>&nbsp;&nbsp;
    
    </br>
    <a href="<c:url value='/findTotalPayments'/>" target="body">Please list total number of payments after Feb 11, 2022</a>&nbsp;&nbsp;
    
  </body>
</html>
