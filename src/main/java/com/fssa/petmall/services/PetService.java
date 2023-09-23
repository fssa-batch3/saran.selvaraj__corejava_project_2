package com.fssa.petmall.services;

import java.sql.SQLException;
import java.util.List;

import com.fssa.petmall.dao.PetDAO;
import com.fssa.petmall.dao.exception.DAOException;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.validation.PetValidator;

public class PetService {

	public static boolean createPet(Pet pet) {
		Pet Pet = new Pet();
		PetDAO petDAO = new PetDAO();
		
		//if(PetValidator.validatePetName(Pet.getRealName()) && PetValidator.validatePetPrice(Pet.getPrice())){
			if(petDAO.createPet(pet)) {
				Logger.debug((pet.getRealName() + " Successfully Registered!"));
				return true;
			} else {
				return false;
			}
		//} else {
			//return false;
		//}
	}
	public List<Pet> listAllPets() throws ServiceException {
		List<Pet> list = null;
		try {
			list = PetDAO.listAllPets();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}
	
	public boolean placeOrder(int uniqueID, String loggedInUserEmail) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		try {
			if(petDAO.placeOrder( uniqueID,loggedInUserEmail)) {
				Logger.debug("Pet successfully Bought!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public List<Pet> orderedPets(String email) throws ServiceException {
		List<Pet> list = null;
		try {
			list = PetDAO.orderedPets(email);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Pet> viewPet(int id) throws ServiceException {
		List<Pet> list = null;
		try {
			list = PetDAO.viewPet(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}


	//update user
	public static boolean updatePet(Pet pet) throws ServiceException {
		PetDAO petDAO = new PetDAO();
		if(petDAO.updatePet(pet)) {
			Logger.debug("Pet Details Successfully Updated!");
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
				Logger.debug("Pet Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	
}
