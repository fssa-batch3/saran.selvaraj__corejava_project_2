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
import com.fssa.petmall.utills.*;

public class PetDAO {

	   
		
        
	    public boolean createPet(Pet pet) {
	        String insertQuery = "INSERT INTO pet_details (realName, personalName, dob, specialTalent, behavior, price, mobileNumber, vaccinationCertificate,image,soldUserEmail) VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";
	        Connection connection = Utills.getConnection();
	        try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {
	            pst.setString(1, Pet.getRealName());
	            pst.setString(2, Pet.getPersonalName());
	            pst.setString(3, Pet.getDob()); // Convert java.util.Date to java.sql.Date
	            pst.setString(4, Pet.getSpecialTalent());
	            pst.setString(5, Pet.getBehavior());
	            pst.setString(6, Pet.getPrice());
	            pst.setString(7, Pet.getMobileNumber());
	            pst.setString(8, Pet.getVaccinationCertificate());
	            pst.setString(9, Pet.getpetimageurl());
	            pst.setString(10,Pet.getsoldUserEmail());

	            int rowsInserted = pst.executeUpdate();
	            connection.close();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	        	Logger.error(e);
	            return false;
	        }
	    }

	    public boolean updatePet(Pet pet) {
	        String insertQuery = "INSERT INTO pet_details (realName, personalName, dob, specialTalent, behavior, price, mobileNumber, vaccinationCertificate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        Connection connection = Utills.getConnection();
	        try (PreparedStatement pst = connection.prepareStatement(insertQuery)) {
	            pst.setString(1, Pet.getRealName());
	            pst.setString(2, Pet.getPersonalName());
	            pst.setString(3, Pet.getDob()); // Convert java.util.Date to java.sql.Date
	            pst.setString(4, Pet.getSpecialTalent());
	            pst.setString(5, Pet.getBehavior());
	            pst.setString(6, Pet.getPrice());
	            pst.setString(7, Pet.getMobileNumber());
	            pst.setString(8, Pet.getVaccinationCertificate());

	            int rowsInserted = pst.executeUpdate();
	            connection.close();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	        	Logger.error(e);
	            
	            return false;
	        }
	    }
		public boolean deletePet(int uniqueID , int isNotBought) throws SQLException {
			Connection connection = Utills.getConnection();
			
			
			 String selectQuery = "UPDATE pet_details SET isNotBought = ? WHERE uniqueId = " + uniqueID + ";";
			 PreparedStatement pst = connection.prepareStatement(selectQuery);
			pst.setInt(1,isNotBought);
			
			int rows = pst.executeUpdate();
			pst.close();
			connection.close();
			return (rows == 1);
		}
		
		public List<Pet> listAllPets(String email) throws DAOException {
		    List<Pet> list1 = new ArrayList<>();
		    
		    try (Connection connection = Utills.getConnection();
		         PreparedStatement pst = connection.prepareStatement("SELECT * FROM pet_details WHERE isNotBought = 0;")) {
		        
		        try (ResultSet resultSet = pst.executeQuery()) {
		            
		            while (resultSet.next()) {
		            int id = resultSet.getInt("uniqueID");
		            String uniqueID = String.valueOf(id);
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
		            	int id = resultSet.getInt("uniqueID");
			            String uniqueID = String.valueOf(id);
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
