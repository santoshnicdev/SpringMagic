
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body style="background-color: lightblue">

	<h3 align="center">Login page</h3>

	<form:form modelAttribute="login" method="POST" action="loginurl">
		<p align="center">
			Username:
			<form:input path="email" />
			<font color="red"><form:errors path="email" /></font>
		</p>
		<p align="center">
			Password:
			<form:password path="password" />
			<font color="red"><form:errors path="password" /></font>
		</p>
		<p align="center">
			<input type="submit" value="Login" />
		</p>
	</form:form>

</body>
</html>
