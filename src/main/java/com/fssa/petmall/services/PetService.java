package com.fssa.petmall.services;

import java.sql.SQLException;

import com.fssa.petmall.dao.PetDAO;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;
import com.fssa.petmall.validation.PetValidator;
import com.fssa.petmall.validation.UserValidator;
import com.fssa.petmall.validation.exception.InvalidPetException;
import com.fssa.petmall.validation.exception.InvalidUserException;

public class PetService {
	
	public static boolean createPet(Pet pet) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		Pet pet1 = new Pet(Pet.getReal_name(),Pet.getPrice(), Pet.getVaccination());
		try {
		if(PetValidator.validatePetName(pet.getReal_name(),PetValidator.validatePetPrice(pet.getPrice()))){ 
			if(petDAO.createPet(pet1)) {
				System.out.println(pet.getReal_name() + " Successfully Registered!");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	//update user
	public static boolean updatePet(String Vaccination,int price) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		try {
			if(petDAO.updatePet(Vaccination , price)) {
				System.out.println("User Details Successfully Updated!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	//delete user
	public static boolean deletePet(int uniqueID , int is_deleted) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		try {
			if(petDAO.DeletePet( uniqueID,is_deleted)) {
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
