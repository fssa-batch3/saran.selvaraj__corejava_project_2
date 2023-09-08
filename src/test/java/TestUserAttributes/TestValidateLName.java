package TestUserAttributes;

import com.fssa.petmall.utills.*;
import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.UserService;
import com.google.protobuf.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import static org.junit.jupiter.api.Assertions.*;

class TestValidateLName {
 
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	void TestNameSuccess() throws ServiceException {	
		    String name ="saran";
			try {
				assertTrue(UserValidator.validateName(name));
			} catch (Exception e) {
				Logger.debug("UserName Invalid");
				fail();
			}
	} 
	
	@Test
	void TestNameFailure() throws ServiceException {	
		    String name = null;
			try {		
				assertFalse(UserValidator.validateName(name));
			} catch (Exception e) {
				Logger.debug("UserName Invalid");
				fail();
			}
	} 
}
