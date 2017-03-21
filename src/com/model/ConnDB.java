package com.model;

import java.sql.*;


public class ConnDB {
	private Connection ct=null;
	public Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("chenggong");
			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/xsgl?user=root&password=12345");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ct;
	}
}