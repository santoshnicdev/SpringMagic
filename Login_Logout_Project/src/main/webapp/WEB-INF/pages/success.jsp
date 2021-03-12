<%@ page session="false" isELIgnored="false"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Success</title>
</head>
<body>

	<h1>Welcome ${name}</h1>
	<br>
	<table>
	<tr>
	<th>
	<h4>
		<a href="add" class="btn btn-primary btn-lg">ADD</a>
	</h4>
	</th>
	<th>
	<h4>
		<a href="view" class="btn btn-primary btn-lg">VIEW</a>
	</h4>
	</th>
	<th>
	<h4>
		<a href="loginBack" class="btn btn-primary btn-lg">UPDATE</a>
	</h4>
	</th>
	<th>
	<h4>
		<a href="loginBack" class="btn btn-primary btn-lg">DELETE</a>
	</h4>
	</th>
	</tr>
	</table>


</body>
</html>
