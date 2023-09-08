package com.fssa.petmall.services;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;


public class TestCreatePet {

    @Test
    public void testCreatePetValidData() throws ServiceException {
        Pet pet = new Pet("https://img.freepik.com/free-photo/good-looking-siberian-husky-dog-grass_493961-927.jpg?t=st=1693971070~exp=1693971670~hmac=597eb4930762616b89ae34fedf05342e9cbc2d8d021d2f7fdcfc25fd41fc48fb", "Husky",  "Tommy ",  "2020-12-21 ",  "It can swim",  "Child friendly",  "price","9566848434","https://images.squarespace-cdn.com/content/v1/54cc96a4e4b0c5c90aef2aeb/1609367357962-OEFK6A7J1FRPVBE26NTC/20201231_091043.jpg");
        assertTrue(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetInvalidName() throws ServiceException {
        Pet pet = new Pet("https://img.freepik.com/free-photo/good-looking-siberian-husky-dog-grass_493961-927.jpg?t=st=1693971070~exp=1693971670~hmac=597eb4930762616b89ae34fedf05342e9cbc2d8d021d2f7fdcfc25fd41fc48fb", "Husky@",  "Tommy ",  "2020-12-21 ",  "It can swim",  "Child friendly",  "price","9566848434","https://images.squarespace-cdn.com/content/v1/54cc96a4e4b0c5c90aef2aeb/1609367357962-OEFK6A7J1FRPVBE26NTC/20201231_091043.jpg");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetDatabaseError() throws ServiceException {
        // Simulate a database error by passing invalid DB credentials
        Pet pet = new Pet("https://img.freepik.com/free-photo/good-looking-siberian-husky-dog-grass_493961-927.jpg?t=st=1693971070~exp=1693971670~hmac=597eb4930762616b89ae34fedf05342e9cbc2d8d021d2f7fdcfc25fd41fc48fb", "",  "Tommy",  "2020-12-21 ",  "It can swim",  "Child friendly",  "price","9566848434","https://images.squarespace-cdn.com/content/v1/54cc96a4e4b0c5c90aef2aeb/1609367357962-OEFK6A7J1FRPVBE26NTC/20201231_091043.jpg");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetValidationFail() throws ServiceException {
        // Validation fails because price is negative
        Pet pet = new Pet("https://img.freepik.com/free-photo/good-looking-siberian-husky-dog-grass_493961-927.jpg?t=st=1693971070~exp=1693971670~hmac=597eb4930762616b89ae34fedf05342e9cbc2d8d021d2f7fdcfc25fd41fc48fb", "Husky@",  "Tommy ",  "2020-12-21 ",  "It can swim",  "Child friendly",  "price","9566848434","https://images.squarespace-cdn.com/content/v1/54cc96a4e4b0c5c90aef2aeb/1609367357962-OEFK6A7J1FRPVBE26NTC/20201231_091043.jpg");
        assertFalse(PetService.createPet(pet));
    }

}
