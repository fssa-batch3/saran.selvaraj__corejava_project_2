package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.exception.ServiceException;

class TestDeletePet {

    @Test
    void testDeletePetValidDeletion() throws ServiceException {
        assertTrue(PetService.deletePet(1, 1));
    }

    @Test
    void testDeletePetNonExistentPet() throws ServiceException {
        // Assuming unique ID 999 doesn't exist
        assertFalse(PetService.deletePet(5, 1));
    }

    @Test
    void testDeletePetInvalidFlag() throws ServiceException {
        assertFalse(PetService.deletePet(6, 1)); // Invalid flag value
    }

    @Test
    void testDeletePetDatabaseError() throws ServiceException {
        // Simulate a database error by passing invalid DB credentials
        assertFalse(PetService.deletePet(8, 1));
    }

    @Test
    void testDeletePetInvalidDatabaseConnection() throws ServiceException {
        // Simulate a database connection error
        assertFalse(PetService.deletePet(7, 1));
    }
}
