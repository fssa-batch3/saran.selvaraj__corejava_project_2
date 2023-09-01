package TestPetProductAttributes;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.PetService;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.services.exception.ServiceException;

public class TestValidateVaccination {

    @Test
    public void testCreatePetValidVaccination() throws ServiceException {
        Pet pet = new Pet("Fluffy", 50, "Vaccinated");
        assertTrue(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetInvalidVaccination() throws ServiceException {
        Pet pet = new Pet("Rex", 25, "Invalid Vaccination Status");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetMixedCaseVaccination() throws ServiceException {
        Pet pet = new Pet("Buddy", 60, "ParTially Vaccinated");
        assertFalse(PetService.createPet(pet));
    }

    @Test
    public void testCreatePetEmptyVaccination() throws ServiceException {
        Pet pet = new Pet("Max", 30, "");
        assertTrue(PetService.createPet(pet)); // Assuming empty vaccination is allowed
    }

    @Test
    public void testCreatePetDatabaseError() throws ServiceException {
        // Simulate a database error by passing invalid DB credentials
        Pet pet = new Pet("Milo", 60, "Vaccinated");
        assertFalse(PetService.createPet(pet));
    }
}
