package com.pragati.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pragati.dao.StudentDAO;
import com.pragati.entities.Student;

public class SaveServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String country = request.getParameter("country");
		
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setPass(password);
		s.setCountry(country);
		
		int status = StudentDAO.save(s);
		if(status > 0) {
			out.println("<h3> 1 record inserted</h3>");
		}
		else {
			out.println();
		}
		out.close();
	
	}
}
