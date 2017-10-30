package com.zf.jdbc;

import java.sql.*;

public class JDBC {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/stall?useSSL=false";
	private static final String USER="root";
	private static final String PASSWORD="root";
	private static  Connection conn=null;
	static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return conn;
	}
	public static void main(String[] args) {
		try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	 Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	    	 Statement stmt = conn.createStatement();
	    	 ResultSet rs = stmt.executeQuery("select user_id from user");
	    	 while(rs.next()){
	    		 System.out.println(rs.getString("user_id"));
	    	 }
		} catch (Exception e) {
			// TODO: handle exception
		}

     }
}
