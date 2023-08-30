package com.fssa.petmall.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;


public class TestCreatePet {

    @Test
    public void testCreatePetValidData() throws ServiceException {
        Pet pet = new Pet("Fluffy", 50, "Vaccinated");
        assertTrue(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetInvalidName() throws ServiceException {
        Pet pet = new Pet("Inv@lid", 50, "Vaccinated");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetNegativePrice() throws ServiceException {
        Pet pet = new Pet("Rex", -10, "Not Vaccinated");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetDatabaseError() throws ServiceException {
        // Simulate a database error by passing invalid DB credentials
        Pet pet = new Pet("Buddy", 60, "Vaccinated");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetValidationFail() throws ServiceException {
        // Validation fails because price is negative
        Pet pet = new Pet("Max", -5, "Vaccinated");
        assertFalse(PetService.createPet(pet));
    }

}
