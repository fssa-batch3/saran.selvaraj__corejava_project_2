
package TestUserAttributes;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.petmall.validation.*;

class TestValidateDateOfBirth {

	    @Test
	    void testValidDateOfBirth() {
	        assertTrue(UserValidator.validateDateOfBirth("1990-05-15"));
	    }

	    @Test
	    void testFutureDateOfBirth() {
	        assertFalse(UserValidator.validateDateOfBirth("2025-01-01")); // Assuming future dates are not allowed
	    }

	    @Test
	    void testInvalidDateFormat() {
	        assertFalse(UserValidator.validateDateOfBirth("15-05-1990")); // Invalid date format
	    }

	    @Test
	    void testInvalidDate() {
	        assertFalse(UserValidator.validateDateOfBirth("2020-02-30")); // Invalid date (February 30th)
	    }

	    @Test
	    void testEmptyDateOfBirth() {
	        assertFalse(UserValidator.validateDateOfBirth("")); // Empty date of birth
	    }
}
