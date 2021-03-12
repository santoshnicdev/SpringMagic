<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="numberf" action="res" method="post">
<form:input path="first"/>
<form:input path="second"/>
Select Opt. : <select name="opt">
						<option value="add">Add</option>
						<option value="multi">Multi</option>
						<option value="sub">Sub</option>
						<option value="div">Div</option>
				</select><br>
				<button type="submit" value="Add">Submit</button>
</form:form>
</body>
</html>