package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.services.exception.serviceException;
import com.google.protobuf.ServiceException;

public class TestRegister {

//	public static void main(String[] args) {
//
//		User user1 = new User("Kotti_784","Male" ,"9500320194","2004-12-26", "hacker4@gmail.com","Kottnn@123");
//		UserService userService = new UserService();
//
//		try {
//			if(!userService.registerUser(user1)) {
//				System.out.println("Registration not successful! Error : Validation Failed Or User Already Exist");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@Test
//	public void testRegistrationSuccess() {
//		UserService userService = new UserService();
//		User user1 = new User("Kotti_784","Male" ,"9500320194","2004-12-26", "hacker4@gmail.com","Kotie@123");
//		try {
//
//			assertTrue(UserService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//
//		}
//	}
//
//	@Test
//	public void testInvalidPassword() {
//
//		UserService userService = new UserService();
//		User user1 = new User("Kotti_784","Male" ,"9500320194","2004-12-26", "hacker4@gmail.com","Kotti123");
//		try {
//			assertFalse(UserService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testUserNull() {
//
//		final UserService userService = new UserService();
//		final User user1 = null;
//		
//		 assertThrows(NullPointerException.class, new Executable() {
//			@Override
//			public void execute() throws Throwable {
//			        userService.registerUser(user1);
//			    }
//		});
//	}

}