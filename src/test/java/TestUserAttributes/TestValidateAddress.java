package TestUserAttributes;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.UserService;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.validation.UserValidator;
import com.google.protobuf.ServiceException;
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
