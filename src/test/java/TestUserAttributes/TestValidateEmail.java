package TestUserAttributes;




import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.UserService;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.validation.UserValidator;
import com.google.protobuf.ServiceException;

 class TestValidateEmail {

	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();

	@Test
    void TestEmailSuccess() throws ServiceException {
		    String Email ="saran@gmail.com";
			try {
				assertTrue(UserValidator.validateEmail(Email));
			} catch (Exception e) {
				Logger.debug("UserName Invalid");
				fail();
			}
	}

	@Test
	void TestEmailFailure() throws ServiceException {
		    String Email = null;
			try {
				assertFalse(UserValidator.validateEmail(Email));
			} catch (Exception e) {
				Logger.debug("UserName Invalid");
				fail();
			}
	}
}
