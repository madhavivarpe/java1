package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserValidate
 */
@WebServlet("/UserValidate")
public class UserValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out =response.getWriter();
		String u=request.getParameter("uname");
		String p=request.getParameter("upass");
		response.setContentType(" text/html");
		RequestDispatcher rd;
		
		if(u.equalsIgnoreCase("admin") && (p.equals("admin123"))) {
			//out.println(" user valid");
			//go to successServlet
			rd= request.getRequestDispatcher("SuccessServlet");
		     rd.forward(request, response);
		}
		else
		{
			out.println(" try again");	
			// login page to be displyed again
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
