package com.fssa.petmall.services;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.dao.UserDAO;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;

public class TestUpdateUser {
	
	@Test
	public void testUpdateSuccess() throws ServiceException {
		User user1 = new User("Male","9566848434","2004-12-21");
		int userID = 2;
		UserService userService = new UserService();
		assertTrue(userService.UpdateUser(user1 , userID));
	}
	
	@Test
	public void testUpdateFail() throws ServiceException {
		User user1 = new User("Female","9566848434","2004-12-21");
		int userID = 5;
		UserService userService = new UserService();
		assertFalse(userService.UpdateUser(user1 , userID));
	}

    private static class UserDAOSimulated extends UserDAO {
        private final boolean shouldUpdateSucceed;

        public UserDAOSimulated(boolean shouldUpdateSucceed) {
            this.shouldUpdateSucceed = shouldUpdateSucceed;
        }

        @Override
        public boolean Update(User user, int userID) throws SQLException {
            return shouldUpdateSucceed;
        }
    }

    @Test
    public void testUpdateSuccessful() {
    	User user1 = new User("Female","9566848434","2004-12-21");
		int userID = 2;
        try {
            UserDAOSimulated userDAOSimulated = new UserDAOSimulated(true);

            UserService userService = new UserService();
            userService.LoginUser(user1);

            boolean result = userService.UpdateUser(user1, userID); // Use a valid userID

            assertTrue(result, "Update should be successful");
        } catch (ServiceException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateUnsuccessful() {
    	User user1 = new User("Female","9566848434","2004-12-21");
		int userID = 2;
        try {
            UserDAOSimulated userDAOSimulated = new UserDAOSimulated(false);

            UserService userService = new UserService();
            userService.LoginUser(user1);

            boolean result = userService.UpdateUser(user1, userID); // Use a valid userID

            assertFalse(result, "Update should be unsuccessful");
        } catch (ServiceException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateException() {
    	User user1 = new User("Female","9566848434","2004-12-21");
		int userID = 2;
        try {
            UserDAOSimulated userDAOSimulated = new UserDAOSimulated(false);

            UserService userService = new UserService();
            userService.LoginUser(user1);

            assertThrows(ServiceException.class, () -> userService.UpdateUser(user1, userID), "ServiceException should be thrown");
        } catch (ServiceException e) {
            fail("SQL Exception thrown: " + e.getMessage());
        }
    }

}
