package TestUserAttributes;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.petmall.validation.UserValidator;
class TestValidatePhoneNumber {

	  @Test
	    void testValidPhoneNumber() {
	        assertTrue(UserValidator.validatePhoneNumber("9876543210")); // Assuming 10-digit numbers are valid
	    }

	    @Test
	    void testInvalidPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber("abc123")); // Invalid format
	    }

	    @Test
	    void testEmptyPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber("")); // Empty phone number
	    }

	    @Test
	    void testNullPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber(null)); // Null phone number
	    }

	    @Test
	    void testNonNumericPhoneNumber() {
	        assertFalse(UserValidator.validatePhoneNumber("abcdefghij")); // Non-numeric characters
	    }
}
