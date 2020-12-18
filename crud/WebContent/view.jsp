<%@ page import="java.util.*, com.pragati.entities.Student, com.pragati.dao.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table{
	 width=70%;
	 align="center";
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
	text-align:center;
}
</style>
<title>View JSP Page</title>
</head>
<body>
<table>

<%
	out.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>Country</th></tr>");
	
	List<Student> student = StudentDAO.getAllStudents();
	for(Student s:student){
		out.println("<tr>");
	out.println("<td>"+s.getName()+"</td>");
	out.println("<td>"+s.getEmail()+"</td>");
	out.println("<td>"+s.getPass()+"</td>");
	out.println("<td>"+s.getCountry()+"</td>");
	out.println("</tr>");
	}
	 %>

</table>
</body>
</html>