package freshstocks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import freshstocks.model.User;

public class UserDAO {

	
	 //connect to database
	public Connection getConnection() throws SQLException {
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","root");
	 return connection;
	}
	
	boolean match = false;
//	Get user from DB - Login
   public boolean login(User user) throws SQLException {
		
	   
	   Connection connection = getConnection();
	   
	   String selectQuery = "SELECT * FROM freshstocks WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String Password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailID + " Password: " + Password);
		   
		   if(user.getEmail().equals(emailID) && user.getPassword().equals(Password)) {
			   match = true;
		   }
	   }
	   return match;
	}
   
   //Email Not Exist
   public boolean EmailExist(User user) throws SQLException {
		
	   
	   Connection connection = getConnection();
	   
	   String selectQuery = "SELECT * FROM freshstocks WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String Password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailID + " Password: " + Password);
		   
		   if(user.getEmail().equals(emailID)) {
			   match = true;
		   }
	   }
	   return match;
	}
   
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO freshstocks (userID,username,gender,mobile_number,date_of_birth,email,password) VALUES (?,?,?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, user.getUserID());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getGender());
		pst.setString(4, user.getMobile_number());
		pst.setString(5, user.getDate_of_birth());
		pst.setString(6, user.getEmail());
		pst.setString(7, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}
	
	// update user
	public boolean Update(User user , int userID) throws SQLException {
		   
		   Connection connection = getConnection();
		   
		   String selectQuery = "UPDATE freshstocks SET gender = ?, mobile_number = ?, date_of_birth = ? WHERE userID = " + userID + ";";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		   pst.setString(1, user.getGender());
		   pst.setString(2, user.getMobile_number());
		   pst.setString(3, user.getDate_of_birth());
		   
		 //Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
}
	
	//delete user
	// update user
	public boolean Delete(int userID , int is_deleted) throws SQLException {
		   
		   Connection connection = getConnection();
		   
		   String is_delete = Integer.toString(is_deleted);
		   
		   String selectQuery = "UPDATE freshstocks SET is_deleted = ? WHERE userID = " + userID + ";";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		   pst.setString(1, is_delete);
		   
		 //Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
}
	
}
