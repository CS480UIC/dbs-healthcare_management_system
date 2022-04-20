<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Patient Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>contact No</th>
	</tr>
<c:forEach items="${PatientList}" var="patient">
	<tr>
		<td>${patient.first_name}</td>
		<td>${patient.email}</td>
		<td>${patient.contact_no}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
