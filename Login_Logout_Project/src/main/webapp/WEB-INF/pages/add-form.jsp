<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body style="background-color: lightblue">
	<h3 align="center">Register</h3>
	<form:form modelAttribute="person" method="POST" action="addsubmit">
		<p align="center">
			Name:
			<form:input path="name" />
			<font color="red"><form:errors cssStyle="color:red"
					path="name" /></font>
		</p>
		<p align="center">
			Email:
			<form:input path="email" />
			<font color="red"><form:errors path="email" /></font>
		</p>
		<p align="center">
			Password:
			<form:input path="password" />
			<font color="red"><form:errors path="password" /></font>
		</p>
		<p align="center">
			Father Name:
			<form:input path="fathername" />
			<font color="red"><form:errors path="fathername" /></font>
		</p>
		<p align="center">
			DOB:
			 <form:input path="dob" type="date" />
			<font color="red"><form:errors path="dob" /></font>
		</p>
		<p align="center">
			Country:
			<form:select path="country">
				<form:options items="${ctr}" />

			</form:select>
			<font color="red"><form:errors path="country" /></font>
		</p>
		<p align="center">
			State:
			<form:input path="state" />
			<font color="red"><form:errors path="state" /></font>
		</p>
		<p align="center">
			City:
			<form:input path="city" />
			<font color="red"><form:errors path="city" /></font>
		</p>
		<p align="center">
			Address:
			<form:input path="add" />
			<font color="red"><form:errors path="add" /></font>
		</p>
		<p align="center">
			<input type="submit" value="Submit" />
		</p>
	</form:form>
</body>
</html>
