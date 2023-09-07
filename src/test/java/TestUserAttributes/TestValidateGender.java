package TestUserAttributes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.validation.UserValidator;
class TestValidateGender {

	  @Test
	    void testValidMaleGender() {
	        assertTrue(UserValidator.validateGender("male"));
	    }

	    @Test
	    void testValidFemaleGender() {
	        assertTrue(UserValidator.validateGender("female"));
	    }

	    @Test
	    void testInvalidGender() {
	        assertFalse(UserValidator.validateGender("other")); // Assuming only "male" and "female" are valid
	    }

	    @Test
	    void testEmptyGender() {
	        assertFalse(UserValidator.validateGender("")); // Empty gender
	    }

	    @Test
	    void testNullGender() {
	        assertFalse(UserValidator.validateGender(null)); // Null gender
	    }
}
