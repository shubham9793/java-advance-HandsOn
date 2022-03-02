package com.org.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String username = request.getParameter("name");   
        String password = request.getParameter("pass");
        boolean valid=false;
		System.out.println(username +"  ::  "+password);
				
		Connection con = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loading...");
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sahu9876@");
			System.out.println(" Connecting... to DB ");
			
			 pstmt = con.prepareStatement("select *from login where username=? and password=?");
			 pstmt.setString(1, username);
		        pstmt.setString(2, password);
			System.out.println("Query exceution done!...");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				valid=true;
			}
	
		}catch(ClassNotFoundException e){
			System.out.println("Driver not load "+ e.getMessage());
		}catch(SQLException e){
			System.out.println("SQL Exception "+e.getMessage());
		}
		catch(Exception e){
			
		}finally{
			if(con!=null){
				try{
					con.close(); 
				}catch(Exception e){
					System.out.println("DB connection clossing error "+e.getMessage());
				}
			}
		}
		System.out.println(" out valid= "+valid);
		
			if(valid){
				RequestDispatcher dis= request.getRequestDispatcher("loginSucc.jsp");
				dis.forward(request, response);
			}else{
				response.sendRedirect("loginErr.jsp");
			}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 String skill = request.getParameter("skill");
	       
			
					
			Connection con = null;
			PreparedStatement psmt = null;		
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loading...");
				
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sahu9876@");
				System.out.println(" Connecting... to DB ");
				
				 psmt = con.prepareStatement("select * from login.employee where skill=?");
				
			        psmt.setString(1, skill);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()){
					
					pw.println("Id : "+rs.getInt(1));
					pw.println("Name : "+rs.getString(2));
					pw.println("Skill : "+rs.getString(3));
				}
		
			}catch(ClassNotFoundException e){
				System.out.println("Driver not load "+ e.getMessage());
			}catch(SQLException e){
				System.out.println(" SQL Exception "+e.getMessage());
			}
			catch(Exception e){
				
			}finally{
				if(con!=null){
					try{
						con.close(); 
					}catch(Exception e){
						System.out.println("Exception is "+e.getMessage());
					}
				}
			}
			System.out.println(" out valid= ");
			
		
		
	}

}