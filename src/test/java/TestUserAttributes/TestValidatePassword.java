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

public class TestValidatePassword {
	
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	public static void TestPasswordSuccess() throws ServiceException {	
		    String Password ="JuneJupiter@2023";
			try {
				assertTrue(validator.validatePassword(Password));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 

	@Test
	public static void TestPasswordFailure() throws ServiceException {	
		    String Password = null;
			try {		
				assertFalse(validator.validatePassword(Password));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
}
