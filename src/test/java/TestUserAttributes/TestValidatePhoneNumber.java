package TestUserAttributes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.validation.UserValidator;
public class TestValidatePhoneNumber {

	  @Test
	    public void testValidPhoneNumber() {
	        assertTrue(UserValidator.validatePhoneNumber("9876543210")); // Assuming 10-digit numbers are valid
	    }

	    @Test
	    public void testInvalidPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber("abc123")); // Invalid format
	    }

	    @Test
	    public void testEmptyPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber("")); // Empty phone number
	    }

	    @Test
	    public void testNullPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber(null)); // Null phone number
	    }

	    @Test
	    public void testNonNumericPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber("abcdefghij")); // Non-numeric characters
	    }
}
