package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;

class TestLoginUser {


	@Test
	void TestValidUser() throws ServiceException {
		User user1 = new User("acker4@gmail.com","Kotie@123");
		assertTrue(UserService.loginUser(user1));
	}

	@Test
	void TestInValidUser() throws ServiceException {
		User user1 = new User("acker4@gmail.com","Hacke@123");
		assertFalse(UserService.loginUser(user1));
	}

}
