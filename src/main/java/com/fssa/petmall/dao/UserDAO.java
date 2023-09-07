package com.fssa.petmall.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.petmall.model.User;
import com.fssa.petmall.utills.Utills;

public class UserDAO {

	
	 //connect to database
//	Utils utils = new Utils();
	boolean match = false;
//	Get user from DB - Login
   public boolean login(User user) throws SQLException {
		
	   
	   Connection connection = Utills.getConnection();
	   
	   String selectQuery = "SELECT * FROM user_details WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);
	   
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailID + " Password: " + password);
		   
		   if(user.getEmail().equals(emailID) && user.getPassword().equals(password)) {
			   match = true;
		   }
	   }
	   resultSet.close();
	   connection.close();
	   return match;
	}
   
   //Email Not Exist
   public boolean emailExist(User user) throws SQLException {
		
	   
	   Connection connection = Utills.getConnection();
	   
	   String selectQuery = "SELECT * FROM user_details WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailID + " Password: " + password);
		   
		   if(user.getEmail().equals(emailID)) {
			   match = true;
		   }
	   }
	   resultSet.close();
	   connection.close();
	   return match;
	}
   
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = Utills.getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO user_details (First_name,Last_name,gender,Phone_number,date_of_birth,email,password) VALUES (?,?,?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
//		pst.setInt(1, user.getUserID());
		pst.setString(1, user.getfirst_name());
		pst.setString(2, user.getlast_name());
		pst.setString(3, user.getGender());
		pst.setString(4, user.getPhone_number());
		pst.setString(5, user.getDate_of_birth());
		pst.setString(6, user.getEmail());
		pst.setString(7, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		    pst.close();
		   connection.close();
		
		//Return Successful or not
		return (rows == 1);
	}
	
	// update user
	public boolean update(User user , String email) throws SQLException {
		   
		   Connection connection = Utills.getConnection();
		   
		   String selectQuery = "UPDATE user_details SET  First_name = ?, Last_name = ?,Date_of_birth = ?,Gender = ?,Phone_number = ? WHERE email = ?;";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		  
		   pst.setString(1, user.getfirst_name());
		   pst.setString(2, user.getlast_name());
		   pst.setString(3, user.getDate_of_birth());
		   pst.setString(4, user.getGender());
		   pst.setString(5, user.getPhone_number());
		   pst.setString(6,email);
		   
		 //Execute query
			int rows = pst.executeUpdate();
			pst.close();
			connection.close();
			//Return Successful or not
			return (rows == 1);
}
	
	//delete user
	// update user
	public boolean delete( String email) throws SQLException {
		   
		   Connection connection = Utills.getConnection();
		   
		   
		   
		   String selectQuery = "UPDATE user_details SET is_deleted = ? WHERE Email = ? ;";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		   pst.setInt(1, 1);
		   pst.setString(2, email);
		   
		 //Execute query
			int rows = pst.executeUpdate();
			pst.close();
			connection.close();
			//Return Successful or not
			return (rows == 1);
}
	
}
