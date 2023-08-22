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

public class TestValidateLName {
 
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
	public static void TestNameSuccess() throws ServiceException {	
		    String name ="saran";
			try {
				assertTrue(validator.validateName(name));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
	
	@Test
	public static void TestNameFailure() throws ServiceException {	
		    String name = null;
			try {		
				assertFalse(validator.validateName(name));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
}
