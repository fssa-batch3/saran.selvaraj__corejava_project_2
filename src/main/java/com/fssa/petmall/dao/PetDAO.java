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
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.utills.Utills;

public class PetDAO {

	public boolean createPet(Pet pet) {
		Pet Pet = new Pet();
		String insertQuery = "INSERT INTO pet_details (realName, personalName, dob, specialTalent, behavior, Price, mobileNumber, vaccinationCertificate,image,soldUserEmail) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		Connection connection = Utills.getConnection();
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
			pst.setString(10, pet.getsoldUserEmail());

			int rowsInserted = pst.executeUpdate();
			connection.close();
			return rowsInserted > 0;
		} catch (SQLException e) {
			Logger.error(e);
			return false;
		}
	}

	public boolean updatePet(Pet pet) {
		Pet Pet = new Pet();
		String insertQuery = "Update pet_details SET realName = ?,  personalName = ? , dob = ? , specialTalent = ? , behavior = ? , price = ?, mobileNumber = ?, vaccinationCertificate = ? ,image = ? Where uniqueId = ?";
		Connection connection = Utills.getConnection();
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
			pst.setInt(10, pet.getuniqueID());

			int rowsInserted = pst.executeUpdate();
			connection.close();
			return rowsInserted > 0;
		} catch (SQLException e) {
			Logger.error(e);

			return false;
		}
	}

	public boolean deletePet(int uniqueID, int isNotBought) throws SQLException {
		Connection connection = Utills.getConnection();

		String selectQuery = "UPDATE pet_details SET isNotBought = ? WHERE uniqueId = " + uniqueID + ";";
		PreparedStatement pst = connection.prepareStatement(selectQuery);
		pst.setInt(1, isNotBought);

		int rows = pst.executeUpdate();
		pst.close();
		connection.close();
		return (rows == 1);
	}

	public static List<Pet> listAllPets() throws DAOException {
		List<Pet> list = new ArrayList<>();

		try (Connection connection = Utills.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("SELECT * FROM pet_details WHERE isNotBought = 1;")) {

			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {

					Pet pet = new Pet();

					pet.setuniqueID(resultSet.getInt("uniqueId"));
					pet.setRealName(resultSet.getString("realName"));
					pet.setPrice(resultSet.getString("Price"));
					pet.setpetimageurl(resultSet.getString("image"));
					pet.setPersonalName(resultSet.getString("personalName"));
					pet.setDob(resultSet.getString("dob"));
					pet.setSpecialTalent(resultSet.getString("specialTalent"));
					pet.setBehavior(resultSet.getString("behavior"));
					pet.setMobileNumber(resultSet.getString("mobileNumber"));
					pet.setVaccinationCertificate(resultSet.getString("vaccinationCertificate"));
					pet.setsoldUserEmail(resultSet.getString("soldUserEmail"));

					list.add(pet);

				}
			}
		} catch (SQLException e) {
			throw new DAOException(PetModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return list;
	}
	
	public static List<Pet> viewPet(int id) throws DAOException {
		List<Pet> list = new ArrayList<>();
        
		try (Connection connection = Utills.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("SELECT * FROM pet_details WHERE uniqueId = ?;")) {
			pst.setInt(1, id);
			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {

					Pet pet = new Pet();

					pet.setuniqueID(resultSet.getInt("uniqueId"));
					pet.setRealName(resultSet.getString("realName"));
					pet.setPrice(resultSet.getString("Price"));
					pet.setpetimageurl(resultSet.getString("image"));
					pet.setPersonalName(resultSet.getString("personalName"));
					pet.setDob(resultSet.getString("dob"));
					pet.setSpecialTalent(resultSet.getString("specialTalent"));
					pet.setBehavior(resultSet.getString("behavior"));
					pet.setMobileNumber(resultSet.getString("mobileNumber"));
					pet.setVaccinationCertificate(resultSet.getString("vaccinationCertificate"));
					pet.setsoldUserEmail(resultSet.getString("soldUserEmail"));

					list.add(pet);

				}
			}
		} catch (SQLException e) {
			throw new DAOException(PetModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return list;
	}
	
	
	public boolean placeOrder(int uniqueID, String loggedInUserEmail) throws SQLException {
		Connection connection = Utills.getConnection();

		String selectQuery = "UPDATE pet_details SET BoughtUserEmail = ?,isNotBought = 0 WHERE uniqueId = " + uniqueID + ";";
		PreparedStatement pst = connection.prepareStatement(selectQuery);
		pst.setString(1, loggedInUserEmail);

		int rows = pst.executeUpdate();
		pst.close();
		connection.close();
		return (rows == 1);
	}
	
	public boolean cancelOrder(int uniqueID) throws SQLException {
		Connection connection = Utills.getConnection();

		String selectQuery = "UPDATE pet_details SET BoughtUserEmail = null,isNotBought = 1 WHERE uniqueId = " + uniqueID + ";";
		PreparedStatement pst = connection.prepareStatement(selectQuery);
		

		int rows = pst.executeUpdate();
		pst.close();
		connection.close();
		return (rows == 1);
	}
	
	
	
	public static List<Pet> orderedPets(String email) throws DAOException {
		List<Pet> list = new ArrayList<>();
        
		try (Connection connection = Utills.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM pet_details WHERE BoughtUserEmail = ? and isNotBought = 0;")) {
			pst.setString(1, email);
			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {

					Pet pet = new Pet();

					pet.setuniqueID(resultSet.getInt("uniqueId"));
					pet.setRealName(resultSet.getString("realName"));
					pet.setPrice(resultSet.getString("Price"));
					pet.setpetimageurl(resultSet.getString("image"));
					pet.setPersonalName(resultSet.getString("personalName"));
					pet.setDob(resultSet.getString("dob"));
					pet.setSpecialTalent(resultSet.getString("specialTalent"));
					pet.setBehavior(resultSet.getString("behavior"));
					pet.setMobileNumber(resultSet.getString("mobileNumber"));
					pet.setVaccinationCertificate(resultSet.getString("vaccinationCertificate"));
					pet.setsoldUserEmail(resultSet.getString("soldUserEmail"));

					list.add(pet);

				}
			}
		} catch (SQLException e) {
			throw new DAOException(PetModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return list;
	}
	

	public static List<Pet> soldPets(String email) throws DAOException {
		List<Pet> list = new ArrayList<>();
        
		try (Connection connection = Utills.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM pet_details WHERE soldUserEmail = ? and isNotBought = 0;")) {
			    pst.setString(1, email);
			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {

					Pet pet = new Pet();

					pet.setuniqueID(resultSet.getInt("uniqueId"));
					pet.setRealName(resultSet.getString("realName"));
					pet.setPrice(resultSet.getString("Price"));
					pet.setpetimageurl(resultSet.getString("image"));
					pet.setPersonalName(resultSet.getString("personalName"));
					pet.setDob(resultSet.getString("dob"));
					pet.setSpecialTalent(resultSet.getString("specialTalent"));
					pet.setBehavior(resultSet.getString("behavior"));
					pet.setMobileNumber(resultSet.getString("mobileNumber"));
					pet.setVaccinationCertificate(resultSet.getString("vaccinationCertificate"));
					pet.setsoldUserEmail(resultSet.getString("soldUserEmail"));

					list.add(pet);

				}
			}
		} catch (SQLException e) {
			throw new DAOException(PetModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return list;
	}
	
}