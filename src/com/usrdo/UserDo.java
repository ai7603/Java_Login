package com.usrdo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.ConnectDB;
import com.usr.User;

public class UserDo{
	public void saveUser(User user){
		Connection conn = ConnectDB.getConnection();
		String sql = "insert into user(username, password) values(?, ?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectDB.closeConnection(conn);
		}
	}
	
	public User login(String username, String password){
		User user = null;
		
		Connection conn = ConnectDB.getConnection();
		
		String sql = "select * from user where username = ? and password = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			rs.close();
			
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectDB.closeConnection(conn);
		}
		return user;
	}
	
	public boolean userIsExist(String username){
		Connection conn = ConnectDB.getConnection();
		
		String sql = "select * from user where username = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs =  ps.executeQuery();
			if(!rs.next()){
				rs.close();
				ps.close();
				return true;
			}
			rs.close();
			ps.close();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.closeConnection(conn);
		}
		
		return false;
	}
}