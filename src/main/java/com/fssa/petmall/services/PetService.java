package com.fssa.petmall.services;

import java.sql.SQLException;

import java.util.List;

import com.fssa.petmall.dao.PetDAO;
import com.fssa.petmall.dao.exception.DAOException;
import com.fssa.petmall.model.*;

import com.fssa.petmall.services.exception.ServiceException;
import com.fssa.petmall.validation.PetValidator;


public class PetService {
	
	public static boolean createPet(Pet pet) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		Pet pet1 = new Pet(Pet.getpetimageurl(),Pet.getRealName(),Pet.getPersonalName(),pet.getDob(), pet.getSpecialTalent(), pet.getBehavior(), Pet.getPrice(),pet.getMobileNumber(), Pet.getVaccinationCertificate());
		if(PetValidator.validatePetName(pet.getRealName(),PetValidator.validatePetPrice(pet.getPrice()))){ 
			if(petDAO.createPet(pet1)) {
				System.out.println(pet.getRealName() + " Successfully Registered!");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public List<Pet> listCourse(int userID) throws ServiceException {
		PetDAO courseDAO = new PetDAO();
		try {
			return courseDAO.readCourse(userID);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public List<Pet> getAllPet() throws ServiceException {
		PetDAO PetDAO = new PetDAO();
		try {
			return PetDAO.getAllCourse();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	//update user
	public static boolean updatePet(Pet pet) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		if(petDAO.updatePet(pet)) {
			System.out.println("User Details Successfully Updated!");
			return true;
		} else {
			return false;
		}
	}
	
	
	//delete user
	public static boolean deletePet(int uniqueID , int isNotBought) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		try {
			if(petDAO.DeletePet( uniqueID,isNotBought)) {
				System.out.println("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
}
