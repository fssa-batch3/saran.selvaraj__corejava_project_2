package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.exception.ServiceException;

public class TestUpdatePet {

	 @Test
	    public void testUpdatePetValidData() throws ServiceException {
	        assertTrue(PetService.updatePet("Updated Vaccination", 75));
	    }

	    @Test
	    public void testUpdatePetInvalidVaccination() throws ServiceException {
	        assertFalse(PetService.updatePet("Inv@lid", 75));
	    }

	    @Test
	    public void testUpdatePetNegativePrice() throws ServiceException {
	        assertFalse(PetService.updatePet("Vaccinated", -10));
	    }

	    @Test
	    public void testUpdatePetNonExistentPet() throws ServiceException {
	        // Assuming unique ID 999 doesn't exist
	        assertFalse(PetService.updatePet("Vaccinated", 75));
	    }

	    @Test
	    public void testUpdatePetDatabaseError() throws ServiceException {
	        // Simulate a database error by passing invalid DB credentials
	        assertFalse(PetService.updatePet("Vaccinated", 75));
	    }
}
