package TestDeleteFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.User;
import freshstocks.services.UserService;

public class TestDelete {

	public static void main(String[] args) {

		int userID = 11;
		int is_deleted = 1;
	    User user1 = new User(userID);
	    UserService userService = new UserService();

	    try {
	        if (!userService.DeleteUser(userID,is_deleted)) {
	            System.out.println("Delete User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void TestDeleteSuccess() throws ServiceException {
		int userID = 11;
		int is_deleted = 1;
		UserService userService = new UserService();
        assertTrue(userService.DeleteUser(userID,is_deleted));
	}
	
	@Test
	public void TestDeleteFail() throws ServiceException {
		int userID = 1;
		int is_deleted = 1;
		UserService userService = new UserService();
        assertFalse(userService.DeleteUser(userID,is_deleted));
	}
	
}
