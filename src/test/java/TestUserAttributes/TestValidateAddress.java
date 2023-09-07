package TestUserAttributes;

import java.sql.SQLException;
import java.util.regex.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.validation.exception.InvalidUserException;
import com.google.protobuf.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import static org.junit.jupiter.api.Assertions.*;

class TestValidateAddress {
 
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	void TestAddressSuccess() throws ServiceException {	
		    String Address ="Mariyamman koil theru Palayam";
			try {
				assertTrue(validator.validateName(Address));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
	
	@Test
	void TestAddressFailure() throws ServiceException {	
		    String Address = null;
			try {		
				assertFalse(validator.validateName(Address));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail(); 
			}
	} 
}
