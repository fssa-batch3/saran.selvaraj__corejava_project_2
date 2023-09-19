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
			List<Pet> list = new PetService().listAllPets();
			for(Pet item : list) {
				String realName = item.getpetimageurl();
				System.out.println(realName);
			}
			
		});
	}
}
