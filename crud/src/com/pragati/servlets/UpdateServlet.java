package com.pragati.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import com.pragati.dao.StudentDAO;
import com.pragati.entities.Student;
//import com.pragati.entities.Student;
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		
//		if(StudentDAO.update(name, password) > 0) {
//			out.println("<h3>One record updated</h3>");
//		}
//		else {
//			out.println("<h3>Some error occured</h3>");
//		}
		Student s = new Student();
		s.setName(name);
		s.setPass(password);
		
		int status = StudentDAO.update(s);
		if(status > 0) {
			out.println("<h3> 1 record updated</h3>");
		}
		else {
			out.println("<h3> Can't update record !</h3>");
		}
		out.close();
	}
}