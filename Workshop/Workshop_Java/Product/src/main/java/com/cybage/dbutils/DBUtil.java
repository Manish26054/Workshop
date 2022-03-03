package com.cybage.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/workshop";
	public static final String USER = "root";
	public static final String PASSWORD = "developer";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("DB connected!!!");
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}
	
}
	
