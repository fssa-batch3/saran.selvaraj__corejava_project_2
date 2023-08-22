package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.services.exception.ServiceException;

public class TestDeleteUser {

	public static void main(String[] args) {

		int userID = 1;
		int is_deleted = 1;
	    User user1 = new User(userID);
	    UserService userService = new UserService();

	    try {
	        if (!userService.DeleteUser(userID, is_deleted)) {
	            System.out.println("Delete User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void TestDeleteSuccess() throws ServiceException {
		int userID = 1;
		int is_deleted = 1;
		UserService userService = new UserService();
        assertTrue(userService.DeleteUser(userID,is_deleted));
	}
	
	@Test
	public void TestDeleteFail() throws ServiceException {
		int userID = 4;
		int is_deleted = 1;
		UserService userService = new UserService();
        assertTrue(userService.DeleteUser(userID,is_deleted));
	}
	
	
}
