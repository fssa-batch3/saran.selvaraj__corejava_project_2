package com.fssa.petmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.petmall.model.User;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.utills.Utills;
import com.fssa.petmall.validation.PasswordEncryptAndDecrypt;

public class UserDAO {

	Logger Logger = new Logger();
	 //connect to database
//	Utils utils = new Utils();
	boolean match = false;
//	Get user from DB - Login
	
	  public String Decrypt(String password) {
		   String encryptedpassword = null;
			try {
				encryptedpassword = PasswordEncryptAndDecrypt.decrypt(password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return encryptedpassword;
		   
	   }
   public boolean login(User user) throws SQLException {


	   Connection connection = Utills.getConnection();

	   String selectQuery = "SELECT * FROM user_details WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);

	   ResultSet resultSet = pst.executeQuery();

	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String password = resultSet.getString("password");
		   String DecryptedPassword = Decrypt(password);

		   com.fssa.petmall.utills.Logger.debug("Email: " + emailID + " Password: " + DecryptedPassword);

		   if(user.getEmail().equals(emailID) && user.getPassword().equals(DecryptedPassword)) {
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

		   com.fssa.petmall.utills.Logger.debug("Email: " + emailID + " Password: " + password);

		   if(user.getEmail().equals(emailID)) {
			   match = true;
		   }
	   }
	   resultSet.close();
	   connection.close();
	   return match;
	}

   public String Encrypt(String password) {
	   String encryptedpassword = null;
		try {
			encryptedpassword = PasswordEncryptAndDecrypt.encrypt(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return encryptedpassword;
	   
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
		String EncryptedPassword = Encrypt(user.getPassword());
		pst.setString(7, EncryptedPassword);
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

		   String selectQuery = "UPDATE user_details SET First_name = ?, Last_name = ?,Date_of_birth = ?,Gender = ?,Phone_number = ? WHERE email = ?;";
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
	public User fetchUserIDByEmail(String email) {
		User user1 = null;
		// Database query
		String query = "SELECT * FROM user_details WHERE email = ?";
		try (Connection connection = Utills.getConnection();
		    PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, email);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()){
					int userID = resultSet.getInt("userID");
					String Email = resultSet.getString("Email");
					String First_name = resultSet.getString("First_name");
					String Last_name = resultSet.getString("Last_name");
					String Date_of_birth = resultSet.getString("Date_of_birth");
					String Gender = resultSet.getString("Gender");
					String Phone_number = resultSet.getString("Phone_number");
					String Password = resultSet.getString("Password");
					int isDeleted = resultSet.getInt("is_deleted");
					user1 = new User(userID,First_name,Last_name,Gender,Phone_number,Date_of_birth,isDeleted);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}

}
