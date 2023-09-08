package TestUserAttributes;


import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.UserService;
import com.google.protobuf.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import static org.junit.jupiter.api.Assertions.*;
import com.fssa.petmall.utills.*;
class TestValidateAddress {
 
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	void TestAddressSuccess() throws ServiceException {	
		    String Address ="Mariyamman koil theru Palayam";
			try {
				assertTrue(UserValidator.validateName(Address));
			} catch (Exception e) {
				Logger.debug("UserName Invalid");
				fail();
			}
	} 
	
	@Test
	void TestAddressFailure() throws ServiceException {	
		    String Address = null;
			try {		
				assertFalse(UserValidator.validateName(Address));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail(); 
			}
	} 
}
