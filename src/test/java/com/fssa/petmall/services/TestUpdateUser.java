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

class TestUpdateUser {
	
	@Test
	void testUpdateSuccess() throws ServiceException {
		User user1 = new User("saran2112@gmail.com","9566848434","2004-12-21", null, null);
		String email = "saran@gmal.com";
		UserService userService = new UserService();
		assertTrue(userService.updateUser(user1 , email));
	}
	
	@Test
	void testUpdateFail() throws ServiceException {
		User user1 = new User("Female","9566848434","2004-12-21", null, null);
		String email = "saran@gmal.com";
		UserService userService = new UserService();
		assertFalse(userService.updateUser(user1 , email));
	}

    private static class UserDAOSimulated extends UserDAO {
        private final boolean shouldUpdateSucceed;

        public UserDAOSimulated(boolean shouldUpdateSucceed) {
            this.shouldUpdateSucceed = shouldUpdateSucceed;
        }

        @Override
        public boolean update(User user, String email) throws SQLException {
            return shouldUpdateSucceed;
        }
    }

    @Test
    void testUpdateSuccessful() {
    	User user1 = new User("Female","9566848434","2004-12-21", null, null);
    	String email = "saran@gmal.com";
        try {
            UserDAOSimulated userDAOSimulated = new UserDAOSimulated(true);

            UserService userService = new UserService();
            userService.loginUser(user1);

            boolean result = userService.updateUser(user1, email); // Use a valid userID

            assertTrue(result, "Update should be successful");
        } catch (ServiceException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testUpdateUnsuccessful() {
    	User user1 = new User("Female","9566848434","2004-12-21", null, null);
    	String email = "saran@gmal.com";
        try {
            UserDAOSimulated userDAOSimulated = new UserDAOSimulated(false);

            UserService userService = new UserService();
            userService.loginUser(user1);

            boolean result = userService.updateUser(user1, email); // Use a valid userID

            assertFalse(result, "Update should be unsuccessful");
        } catch (ServiceException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testUpdateException() {
    	User user1 = new User("Female","9566848434","2004-12-21", null, null);
    	String email = "saran@gmal.com";
        try {
            UserDAOSimulated userDAOSimulated = new UserDAOSimulated(false);

            UserService userService = new UserService();
            userService.loginUser(user1);

            assertThrows(ServiceException.class, () -> userService.updateUser(user1, email), "ServiceException should be thrown");
        } catch (ServiceException e) {
            fail("SQL Exception thrown: " + e.getMessage());
        }
    }

}
