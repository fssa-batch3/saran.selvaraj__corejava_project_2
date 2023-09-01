package TestUserAttributes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.validation.UserValidator;
public class TestValidateGender {

	  @Test
	    public void testValidMaleGender() {
	        assertTrue(UserValidator.validateGender("male"));
	    }

	    @Test
	    public void testValidFemaleGender() {
	        assertTrue(UserValidator.validateGender("female"));
	    }

	    @Test
	    public void testInvalidGender() {
	        assertFalse(UserValidator.validateGender("other")); // Assuming only "male" and "female" are valid
	    }

	    @Test
	    public void testEmptyGender() {
	        assertFalse(UserValidator.validateGender("")); // Empty gender
	    }

	    @Test
	    public void testNullGender() {
	        assertFalse(UserValidator.validateGender(null)); // Null gender
	    }
}
