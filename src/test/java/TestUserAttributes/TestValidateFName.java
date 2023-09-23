package TestUserAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.UserService;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.validation.UserValidator;
import com.google.protobuf.ServiceException;

class TestValidateFName {

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
