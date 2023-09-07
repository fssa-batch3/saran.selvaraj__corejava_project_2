package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.services.exception.ServiceException;

public class TestDeletePet {

    @Test
    public void testDeletePetValidDeletion() throws ServiceException {
        assertTrue(PetService.deletePet(1, 1));
    }

    @Test
    public void testDeletePetNonExistentPet() throws ServiceException {
        // Assuming unique ID 999 doesn't exist
        assertFalse(PetService.deletePet(5, 1));
    }

    @Test
    public void testDeletePetInvalidFlag() throws ServiceException {
        assertFalse(PetService.deletePet(6, 1)); // Invalid flag value
    }

    @Test
    public void testDeletePetDatabaseError() throws ServiceException {
        // Simulate a database error by passing invalid DB credentials
        assertFalse(PetService.deletePet(8, 1));
    }

    @Test
    public void testDeletePetInvalidDatabaseConnection() throws ServiceException {
        // Simulate a database connection error
        assertFalse(PetService.deletePet(7, 1));
    }
}
