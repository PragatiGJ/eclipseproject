package com.pragati.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pragati.dao.StudentDAO;

public class DeleteServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		if(StudentDAO.delete(name) > 0) {
			out.println("<h3>One record deleted</h3>");
		}
		else {
			out.println("<h3>Some error occured</h3>");
		}
	}

}
