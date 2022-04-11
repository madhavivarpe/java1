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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection conn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		String email=request.getParameter("semail");
		
		
		DbConnect dconn=new DbConnect();
		conn=dconn.getConnection();
		
		
		try {
			String query="select * from edustudent where semail=?";
			
		PreparedStatement	 pst=conn.prepareStatement(query);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				
				String delete="Delete from edustudent  where semail=?";
			    pst=conn.prepareStatement(delete);
			   
			    pst.setString(1, email);
			    int i=pst.executeUpdate();
			    if(i>0) {
			    	out.println("Delete Record");
			    }
			    
			}
			else {
				out.println("user not registered");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


		
	}


