package TestUserAttributes;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.UserService;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.validation.UserValidator;
import com.google.protobuf.ServiceException;

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
