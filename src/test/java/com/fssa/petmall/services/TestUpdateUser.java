package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;

public class TestUpdateUser {
	
	public static void main(String[] args) {

	    User user1 = new User("Male", "9566848434", "2004-12-21");
	    int userID = 1;
	    UserService userService = new UserService();

	    try {
	        if (!userService.UpdateUser(user1, userID)) {
	            System.out.println("Update User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Update User not Failed!");
	    }

	}
	
	@Test
	public void testUpdateSuccess() throws ServiceException {
		User user1 = new User("Male","9566848434","2004-12-21");
		int userID = 2;
		UserService userService = new UserService();
		assertTrue(userService.UpdateUser(user1 , userID));
	}
	
	@Test
	public void testUpdateFail() throws ServiceException {
		User user1 = new User("Male","9566848434","2004-12-21");
		//this userID doesn't exist so, it return false and our test cases is true
		int userID = 5;
		UserService userService = new UserService();
		assertFalse(userService.UpdateUser(user1 , userID));
	}

}
