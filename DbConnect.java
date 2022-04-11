package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	//Database connection , get the connection
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/madhavi";
			String un="root";
		    String pass="root";
		    Connection conn=null;
		    
		    public Connection getConnection() {
		    	
		    	try {
		    	  Class.forName(driver);
		    	  conn=DriverManager.getConnection(url,un,pass);
		    	  
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	if(conn==null) {
		    		System.out.println("Connection Error");
		    	}
		    	
				return conn;
		    }
			
		}


