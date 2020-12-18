package com.pragati.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pragati.dao.StudentDAO;
import com.pragati.entities.Student;

public class ViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Student> student = StudentDAO.getAllStudents();
		
		for(Student s : student) {
			out.println(s.getName()+" "+s.getEmail()+" "+s.getPass()+" "+s.getCountry()+"<br>");
		}
	}

}
