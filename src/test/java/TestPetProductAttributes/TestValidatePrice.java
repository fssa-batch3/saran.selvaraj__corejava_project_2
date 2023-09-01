package TestPetProductAttributes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;
import java.sql.SQLException;
import java.util.regex.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.validation.exception.InvalidUserException; 	
import com.fssa.petmall.validation.PetValidator;
import static org.junit.jupiter.api.Assertions.*;
public class TestValidatePrice {
	 @Test
	    public void testCreatePetValidPrice() throws ServiceException {
	        Pet pet = new Pet("Fluffy", 50, "Vaccinated");
	        assertTrue(PetService.createPet(pet));
	    }

	    @Test
	    public void testCreatePetZeroPrice() throws ServiceException {
	        Pet pet = new Pet("Rex", 0, "Not Vaccinated");
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	    public void testCreatePetNegativePrice() throws ServiceException {
	        Pet pet = new Pet("Buddy", -10, "Vaccinated");
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	    public void testCreatePetLargePrice() throws ServiceException {
	        Pet pet = new Pet("Max", 1000000, "Vaccinated");
	        assertTrue(PetService.createPet(pet)); // Assuming large prices are allowed
	    }

	    @Test
	    public void testCreatePetDatabaseError() throws ServiceException {
	        // Simulate a database error by passing invalid DB credentials
	        Pet pet = new Pet("Milo", 60, "Vaccinated");
	        assertFalse(PetService.createPet(pet));
	    }
	

}
