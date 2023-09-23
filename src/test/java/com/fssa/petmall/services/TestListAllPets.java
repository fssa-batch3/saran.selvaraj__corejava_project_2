package com.fssa.petmall.services;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;


class TestListAllPets {

	@Test
	void listAllpets() throws ServiceException{
		assertDoesNotThrow(() -> {
		
			PetService PetService = new PetService();
			List<Pet> list = PetService.listAllPets();
				System.out.println(list.get(0).getDob());


		});
	}
}
