package com.fssa.petmall.services;

import java.sql.SQLException;


import java.util.List;

import com.fssa.petmall.dao.PetDAO;
import com.fssa.petmall.dao.exception.DAOException;
import com.fssa.petmall.model.*;

import com.fssa.petmall.services.exception.ServiceException;
import com.fssa.petmall.validation.PetValidator;
import com.fssa.petmall.utills.*;

public class PetService {
	
	public static boolean createPet(Pet pet) {
		PetDAO petDAO = new PetDAO();
		Pet pet1 = new Pet(Pet.getpetimageurl(),Pet.getRealName(),Pet.getPersonalName(),Pet.getDob(), Pet.getSpecialTalent(), Pet.getBehavior(), Pet.getPrice(),Pet.getMobileNumber(), Pet.getVaccinationCertificate(),Pet.getsoldUserEmail());
		if(PetValidator.validatePetName(Pet.getRealName()) && PetValidator.validatePetPrice(Pet.getPrice())){ 
			if(petDAO.createPet(pet1)) {
				Logger.debug((Pet.getRealName() + " Successfully Registered!"));
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public List<Pet> listAllPets(String email) throws ServiceException {
		PetDAO courseDAO = new PetDAO();
		try {
			return courseDAO.listAllPets(email);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public List<Pet> getAllPet() throws ServiceException {
		PetDAO petDAO = new PetDAO();
		try {
			return petDAO.getAllCourse();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	//update user
	public static boolean updatePet(Pet pet) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		if(petDAO.updatePet(pet)) {
			Logger.debug("User Details Successfully Updated!");
			return true;
		} else {
			return false;
		}
	}
	
	
	//delete user
	public static boolean deletePet(int uniqueID , int isNotBought) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		try {
			if(petDAO.deletePet( uniqueID,isNotBought)) {
				Logger.debug("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
}
