package com.fssa.petmall.services;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;

class TestUpdatePet {

	 @Test
	    void testUpdatePetValidData(Pet pet) throws ServiceException {
		    
		    Pet pet1 = new Pet("https://img.freepik.com/free-photo/good-looking-siberian-husky-dog-grass_493961-927.jpg?t=st=1693971070~exp=1693971670~hmac=597eb4930762616b89ae34fedf05342e9cbc2d8d021d2f7fdcfc25fd41fc48fb", "Husky", "Tom", "2020-12-21", "It can swim", "Child friendly", "4000", "9566848434", "https://images.squarespace-cdn.com/content/v1/54cc96a4e4b0c5c90aef2aeb/1609367357962-OEFK6A7J1FRPVBE26NTC/20201231_091043.jpg");
			assertTrue(PetService.updatePet(pet1));
	    }

//	    @Test
//	    void testUpdatePetInvalidVaccination(Pet pet) throws ServiceException {
//	        assertFalse(PetService.updatePet(pet));
//	    }
//
//	    @Test
//	    void testUpdatePetNegativePrice(Pet pet) throws ServiceException {
//	        assertFalse(PetService.updatePet(pet));
//	    }
//
//	    @Test
//	    void testUpdatePetNonExistentPet(Pet pet) throws ServiceException {
//	        // Assuming unique ID 999 doesn't exist
//	        assertFalse(PetService.updatePet(pet));
//	    }
//
//	    @Test
//	    void testUpdatePetDatabaseError(Pet pet) throws ServiceException {
//	        // Simulate a database error by passing invalid DB credentials
//	        assertFalse(PetService.updatePet(pet));
//	    }
}
