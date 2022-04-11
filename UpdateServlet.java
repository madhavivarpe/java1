package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param pst 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String email =request.getParameter("semail");
		String pass =request.getParameter("spass");
		
		System.out.println("Inside update doPost");
		DbConnect dconn=new DbConnect();
		conn = dconn.getConnection();
		System.out.println("Connection "+conn);
		String query="Select * from edustudent where semail=?";
		try
		{
			PreparedStatement pst=conn.prepareStatement(query);
			
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				
				String updatepassword ="update edustudent set spass=? where semail=?";
				pst=conn.prepareStatement(updatepassword);
				pst.setString(1, pass);
				pst.setString(2, email);
				int i=pst.executeUpdate();
			
				if(i>0) {
					out.println("Password Change");
				}
				}
			else {
				out.println("Not registered First Register");
			}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
}


