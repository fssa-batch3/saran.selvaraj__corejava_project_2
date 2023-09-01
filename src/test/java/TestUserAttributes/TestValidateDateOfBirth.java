
package TestUserAttributes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.validation.*;

public class TestValidateDateOfBirth {

	    @Test
	    public void testValidDateOfBirth() {
	        assertTrue(UserValidator.validateDateOfBirth("1990-05-15"));
	    }

	    @Test
	    public void testFutureDateOfBirth() {
	        assertFalse(UserValidator.validateDateOfBirth("2025-01-01")); // Assuming future dates are not allowed
	    }

	    @Test
	    public void testInvalidDateFormat() {
	        assertFalse(UserValidator.validateDateOfBirth("15-05-1990")); // Invalid date format
	    }

	    @Test
	    public void testInvalidDate() {
	        assertFalse(UserValidator.validateDateOfBirth("2020-02-30")); // Invalid date (February 30th)
	    }

	    @Test
	    public void testEmptyDateOfBirth() {
	        assertFalse(UserValidator.validateDateOfBirth("")); // Empty date of birth
	    }
}
