<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<fieldset>
		<legend>Registration Form</legend>
		<h2>Save Record</h2>
		<form action="save" method="POST">
			Name:<input type = "text" name="name"><br><br>
			Email:<input type = "email" name="email"><br><br>
			Password:<input type = "password" name="pass"><br><br>
			Country: <select name="country">
				<option value="india">India</option>
				<option value="canada">Canada</option>
				<option value="usa">USA</option>
				<option value="uk">UK</option>
				<option value="Germany">UK</option>
				<option value="Japan">UK</option>
				<option value="Cuba">UK</option>
			</select>
			<br>
			<input type="submit" value="Submit">
			<hr>
			<h3><a href="view.jsp">View Students List</a></h3>
		</form>
	</fieldset>

</body>
</html>