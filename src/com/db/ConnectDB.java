package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB{
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://39.108.144.46:3306/login";
			conn = DriverManager.getConnection(url, "root", "passw0rd");
		}catch(Exception e){
			System.out.println("Connect Error");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}