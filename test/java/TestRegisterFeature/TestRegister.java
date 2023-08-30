package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.google.protobuf.ServiceException;

import petmall.model.User;
import petmall.services.UserService;
import petmall.services.exception.serviceException;

public class TestRegister {

	public static void main(String[] args) {

		User user1 = new User("Saran","Male" ,"9500320194","2004-12-26", "hack@gmail.com","Saran@123");
		UserService userService = new UserService();

		try {
			if(!userService.registerUser(user1)) {
				System.out.println("Registration not successful! Error : Validation Failed Or User Already Exist");
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to Register",e);
		}

	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("Saran","Male" ,"9500320194","2004-12-26", "hacker@gmail.com","Saran@2004");
		try {

			assertTrue(UserService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("Kotti_784","Male" ,"9500320194","2004-12-26", "hacker4@gmail.com","Kotti123");
		try {
			assertFalse(UserService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		
		 assertThrows(NullPointerException.class, () -> {
		        userService.registerUser(user1);
		    });
	}

}