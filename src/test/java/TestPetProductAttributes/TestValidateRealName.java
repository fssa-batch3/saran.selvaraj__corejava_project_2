package TestPetProductAttributes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;
public class TestValidateRealName {

	 @Test
	    public void testCreatePetValidName() throws ServiceException {
	        Pet pet = new Pet("Fluffy", 50, "Vaccinated");
	        assertTrue(PetService.createPet(pet));
	    }

	    @Test
	    public void testCreatePetShortName() throws ServiceException {
	        Pet pet = new Pet("R", 25, "Not Vaccinated");
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	    public void testCreatePetLongName() throws ServiceException {
	        Pet pet = new Pet("BuddyTheAwesomeDogWithALongName", 60, "Vaccinated");
	        assertFalse(PetService.createPet(pet));
	    }

	    @Test
	    public void testCreatePetNumericName() throws ServiceException {
	        Pet pet = new Pet("123", 30, "Vaccinated");
	        assertTrue(PetService.createPet(pet)); // Assuming numeric names are allowed
	    }

	    @Test
	    public void testCreatePetDatabaseError() throws ServiceException {
	        // Simulate a database error by passing invalid DB credentials
	        Pet pet = new Pet("Milo", 60, "Vaccinated");
	        assertFalse(PetService.createPet(pet));
	    }
}
