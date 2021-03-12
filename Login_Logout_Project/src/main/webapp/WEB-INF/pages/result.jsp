<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<a href="/Calculator_Form/excel" class="btn btn-warning">EXCEL EXPORT</a>||<a href="/Calculator_Form/pdf" class="btn btn-warning">PDF EXPORT</a>
	<table align="center" text:color="blue" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Father_Name</th>
			<th>DOB</th>
			<th>Email</th>
			<th>Country</th>
			<th>City</th>
			<th>Operation</th>

		</tr>
		<c:forEach var="per" items="${person}">


         <tr>
				<td>${per[0]}</td>
				<td>${per[1]}</td>
				<td>${per[2]}</td>
				<td>${per[3]}</td>
				<td>${per[4]}</td>
				<td>${per[5]}</td>
				<td>${per[6]}</td>
				<td><a href="/Calculator_Form/delete?id=${per[0]}">Delete</a>||<a href="/Calculator_Form/edit?id=${per[0]}">Edit</a></td>
			</tr>
		</c:forEach>

</table>


</body>
</html>