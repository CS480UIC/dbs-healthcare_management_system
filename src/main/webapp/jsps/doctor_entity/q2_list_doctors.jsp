<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Doctor Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Name</th>
		<th>Department</th>
		<th>contact No</th>
	</tr>
<c:forEach items="${DoctorList}" var="doctor">
	<tr>
		<td>${doctor.first_name}</td>
		<td>${doctor.department}</td>
		<td>${doctor.contact_no}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
