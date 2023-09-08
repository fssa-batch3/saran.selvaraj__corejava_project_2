package TestUserAttributes;


import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.utills.Logger;
import com.google.protobuf.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import static org.junit.jupiter.api.Assertions.*;

class TestValidatePassword {
	
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	void TestPasswordSuccess() throws ServiceException {	
		    String Password ="JuneJupiter@2023";
			try {
				assertTrue(UserValidator.validatePassword(Password));
			} catch (Exception e) {
				Logger.debug("UserName Invalid");
				fail();
			}
	} 

	@Test
	void TestPasswordFailure() throws ServiceException {	
		    String Password = null;
			try {		
				assertFalse(UserValidator.validatePassword(Password));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
}
