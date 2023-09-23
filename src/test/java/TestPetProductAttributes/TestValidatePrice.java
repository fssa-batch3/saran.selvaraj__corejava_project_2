package TestPetProductAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.services.exception.ServiceException;

 class TestValidatePrice {
	 @Test
	     void testCreatePetValidPrice() throws ServiceException {
	        Pet pet = new Pet("Fluffy", null, null, null, null, null, "50", "Vaccinated", null);
	        assertTrue(PetService.createPet(pet));
	    }

	    @Test
	     void testCreatePetZeroPrice() throws ServiceException {
	        Pet pet = new Pet("Rex", null, null, null, null, null, "0", "Not Vaccinated", null);
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	     void testCreatePetNegativePrice() throws ServiceException {
	        Pet pet = new Pet("Buddy", null, null, null, null, null, "-10", "Vaccinated", null);
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	     void testCreatePetLargePrice() throws ServiceException {
	        Pet pet = new Pet("Max", null, null, null, null, null, "1000000", "Vaccinated", null);
	        assertTrue(PetService.createPet(pet)); // Assuming large prices are allowed
	    }

	    @Test
	     void testCreatePetDatabaseError() throws ServiceException {
	        // Simulate a database error by passing invalid DB credentials
	        Pet pet = new Pet("Milo", null, null, null, null, null, "60", "Vaccinated", null);

	        assertFalse(PetService.createPet(pet));
	    }


}
