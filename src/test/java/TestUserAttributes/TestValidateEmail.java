package TestUserAttributes;




import org.junit.jupiter.api.Test;
import com.fssa.petmall.services.UserService;
import com.google.protobuf.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import static org.junit.jupiter.api.Assertions.*;

 class TestValidateEmail {
 
	UserService userService = new UserService();
	static UserValidator validator = new UserValidator();
	
	@Test
    void TestEmailSuccess() throws ServiceException {	
		    String Email ="saran@gmail.com";
			try {
				assertTrue(UserValidator.validateEmail(Email));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail();
			}
	} 
	
	@Test
	void TestEmailFailure() throws ServiceException {	
		    String Email = null;
			try {		
				assertFalse(UserValidator.validateEmail(Email));
			} catch (Exception e) {
				System.out.println("UserName Invalid");
				fail(); 
			}
	} 
}
