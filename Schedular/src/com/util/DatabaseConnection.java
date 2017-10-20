package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;



public class DatabaseConnection {
	   private static final Logger logger = Logger.getLogger("12345");
	  
	 protected  Connection conn;
	 protected  PreparedStatement pstmt;
	 protected  ResultSet reslt;
	    
	     public void getStart(){
	    
	    try{
	        
	    Class.forName("com.mysql.jdbc.Driver");
	    conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/schedular","root","");
	    if(conn!=null){         
	     logger.info("Database connection successful");
	     }  
	}catch(Exception e){
	    logger.info("Error loading database driver");
	}
	   
	    }
}
