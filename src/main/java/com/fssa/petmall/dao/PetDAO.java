package com.fssa.petmall.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.petmall.constants.PetModuleConstants;
import com.fssa.petmall.dao.exception.DAOException;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.utills.Utills;

public class PetDAO {

	 
		//connect to database
	    Utills utills = new Utills();

	    public boolean createPet(Pet pet) {
	        String insertQuery = "INSERT INTO pet_details (realName, personalName, dob, specialTalent, behavior, price, mobileNumber, vaccinationCertificate,image) VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";
	        Connection connection = utills.getConnection();
	        try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {
	            pst.setString(1, pet.getRealName());
	            pst.setString(2, pet.getPersonalName());
	            pst.setString(3, pet.getDob()); // Convert java.util.Date to java.sql.Date
	            pst.setString(4, pet.getSpecialTalent());
	            pst.setString(5, pet.getBehavior());
	            pst.setString(6, pet.getPrice());
	            pst.setString(7, pet.getMobileNumber());
	            pst.setString(8, pet.getVaccinationCertificate());
	            pst.setString(9, pet.getpetimageurl());

	            int rowsInserted = pst.executeUpdate();
	            connection.close();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean updatePet(Pet pet) {
	        String insertQuery = "INSERT INTO pet_details (realName, personalName, dob, specialTalent, behavior, price, mobileNumber, vaccinationCertificate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        Connection connection = utills.getConnection();
	        try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {
	            pst.setString(1, pet.getRealName());
	            pst.setString(2, pet.getPersonalName());
	            pst.setString(3, pet.getDob()); // Convert java.util.Date to java.sql.Date
	            pst.setString(4, pet.getSpecialTalent());
	            pst.setString(5, pet.getBehavior());
	            pst.setString(6, pet.getPrice());
	            pst.setString(7, pet.getMobileNumber());
	            pst.setString(8, pet.getVaccinationCertificate());

	            int rowsInserted = pst.executeUpdate();
	            connection.close();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	            return false;
	        }
	    }
		public boolean DeletePet(int uniqueID , int isNotBought) throws SQLException {
			Connection connection = utills.getConnection();
			
			
			 String selectQuery = "UPDATE pet_details SET isNotBought = ? WHERE uniqueId = " + uniqueID + ";";
			 PreparedStatement pst = connection.prepareStatement(selectQuery);
			pst.setInt(1,isNotBought);
			
			int rows = pst.executeUpdate();
			pst.close();
			connection.close();
			return (rows == 1);
		}
		
		public List<Pet> readCourse(int isNotBought) throws DAOException {
		    List<Pet> list1 = new ArrayList<>();
		    
		    try (Connection connection = Utills.getConnection();
		         PreparedStatement pst = connection.prepareStatement("SELECT * FROM pet_details WHERE isNotBought = 0;")) {
		        
		        try (ResultSet resultSet = pst.executeQuery()) {
		            
		            while (resultSet.next()) {
		            int ID = resultSet.getInt("uniqueID");
		            String uniqueID = String.valueOf(ID);
					String petimageurl = resultSet.getString("petimageurl");
					String realName = resultSet.getString("realName");
					String personalName = resultSet.getString("personalName");
					String dob = resultSet.getString("dob");
					String specialTalent = resultSet.getString("specialTalent");
					String behavior = resultSet.getString("behavior");
					String price = resultSet.getString("price");
					String mobileNumber = resultSet.getString("mobileNumber");
					String vaccinationCertificate = resultSet.getString("vaccinationCertificate");
					
	                
					Pet pet = new Pet(uniqueID, petimageurl, realName, personalName, dob, specialTalent, behavior, price, mobileNumber, vaccinationCertificate);
					list1.add(pet);

				 }
		       }
		        } catch (SQLException e) {
		            throw new DAOException(PetModuleConstants.READ_ERROR_MESSAGE + e);
		        }
		    
		        return list1;
		    }
		
		public List<Pet> getAllCourse() throws DAOException {
		    List<Pet> list1 = new ArrayList<>();
		    try (Connection connection = Utills.getConnection();
		         PreparedStatement pst = connection.prepareStatement("SELECT * FROM course WHERE is_deleted = 0")) {
		        try (ResultSet resultSet = pst.executeQuery()) {
		            
		            while (resultSet.next()) {
		            	int ID = resultSet.getInt("uniqueID");
			            String uniqueID = String.valueOf(ID);
						String petimageurl = resultSet.getString("petimageurl");
						String realName = resultSet.getString("realName");
						String personalName = resultSet.getString("personalName");
						String dob = resultSet.getString("dob");
						String specialTalent = resultSet.getString("specialTalent");
						String behavior = resultSet.getString("behavior");
						String price = resultSet.getString("price");
						String mobileNumber = resultSet.getString("mobileNumber");
						String vaccinationCertificate = resultSet.getString("vaccinationCertificate");
	                
					Pet pet = new Pet(uniqueID, petimageurl, realName, personalName, dob, specialTalent, behavior, price, mobileNumber, vaccinationCertificate);
					list1.add(pet);

				 }
		       }
		        } catch (SQLException e) {
		            throw new DAOException(PetModuleConstants.READ_ERROR_MESSAGE + e);
		        }
		        return list1;
		    }
		
}
