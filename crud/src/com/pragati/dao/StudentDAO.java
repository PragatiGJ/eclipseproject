package com.pragati.dao;
import java.sql.*;
import java.util.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.ArrayList;

import com.pragati.entities.Student;

public class StudentDAO {

	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int save(Student s) {
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPass());
			ps.setString(4, s.getCountry());
			
			status = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Student s) {
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update student set pass = ? where fname = ? ");
			ps.setString(1, s.getPass());
			ps.setString(2, s.getName());
			
			status = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
//	
//	public static int update(String name, String password) {
//		int status = 0;
//		
//		try {
//			Connection conn = StudentDAO.getConnection();
//			
//			PreparedStatement pr = conn.prepareStatement("update student set pass = ? where fname = ? ");
//			
//			pr.setString(1, password);
//			pr.setString(2, name);
//			
//			status = pr.executeUpdate();
//
//			conn.close();
//			pr.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return status;
//	}
	
	public static int delete(String name) {
		int status = 0;
		
		try {
			Connection conn = StudentDAO.getConnection();
			
			PreparedStatement pr = conn.prepareStatement("delete from student where fname = ? ");
			
			pr.setString(1, name);
			
			status = pr.executeUpdate();

			conn.close();
			pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public static List<Student> getAllStudents(){
		
		List<Student> student = new ArrayList<>();
		
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setName(rs.getString(1));
				s.setEmail(rs.getString(2));
				s.setPass(rs.getString(3));
				s.setCountry(rs.getString(4));
				
				student.add(s);
			}
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}

}
