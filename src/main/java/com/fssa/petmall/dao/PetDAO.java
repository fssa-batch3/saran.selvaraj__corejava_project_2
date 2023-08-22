package com.fssa.petmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.utills.Utills;

public class PetDAO {

	 
		//connect to database
	    Utills utills = new Utills();

		public boolean createPetProduct(Pet pet) throws SQLException {
			
			Connection connection = utills.getConnection();
			String insertQuery = "INSERT INTO petproduct_details (uniqueId,realname,Price,Vaccination) VALUES (?,?,?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			
			pst.setString(2,Pet.getReal_name());
			pst.setInt(3,Pet.getPrice());
			pst.setString(4,Pet.getVaccination());
			
			int rows = pst.executeUpdate();
			return (rows == 1);
		}

		public boolean updatePetProduct(Pet pet,int uniqueID) throws SQLException {
			Connection connection = utills.getConnection();
			
			String selectQuery = "UPDATE petproduct_details SET  realname = ?,Price = ?,Vaccination = ? WHERE uniqueId = " + uniqueID+" ;";
			PreparedStatement pst = connection.prepareStatement(selectQuery);
			
			pst.setString(2,Pet.getReal_name());
			pst.setInt(3,Pet.getPrice());
			pst.setString(3,Pet.getVaccination());
			
			int rows = pst.executeUpdate();
			return (rows == 1);
		}
		public boolean DeletePetProduct(int uniqueID , int is_deleted) throws SQLException {
			Connection connection = utills.getConnection();
			
			 String is_delete = Integer.toString(is_deleted);
			 String selectQuery = "UPDATE petproduct_details SET is_deleted = ? WHERE uniqueId = " + uniqueID + ";";
			 PreparedStatement pst = connection.prepareStatement(selectQuery);
			pst.setString(1,is_delete);
			
			int rows = pst.executeUpdate();
			return (rows == 1);
		}
		
}
