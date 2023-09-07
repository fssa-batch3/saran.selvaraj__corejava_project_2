package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.services.exception.ServiceException;

class TestDeleteUser {

	
	
	@Test
	void TestDeleteSuccess() throws ServiceException {
		
		String email = "saran@gmail.com";
		UserService userService = new UserService();
        assertTrue(userService.deleteUser(email));
	}
	
	@Test
	void TestDeleteFail() throws ServiceException {
		
		String email = "saran2005@gmail.com";
		UserService userService = new UserService();
        assertFalse(userService.deleteUser(email));
	}
	
	
}
