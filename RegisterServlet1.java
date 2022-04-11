package com.edu;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistreServlet
 */
@WebServlet("/RegisterServlet1")
public class RegisterServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param conn 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConnect cob=new DbConnect();
		String name=request.getParameter("sname");
		String pass=request.getParameter("spass");
		int age=Integer.parseInt(request.getParameter("sage"));
		String email=request.getParameter("semail");
		PrintWriter out=response.getWriter();
		conn=cob.getConnection();
		String sql="insert into edustudent values(?,?,?,?)";
		try
		{
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3, pass);
			pst.setInt(4, age);
			int i=pst.executeUpdate();
			if(i>0) {
				out.println("Registration success");
			}else {
				out.println("Error occurred");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


