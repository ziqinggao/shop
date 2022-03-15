package com.dirsir.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilConnection {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql:///dirsir";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static Connection getMySQLConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
