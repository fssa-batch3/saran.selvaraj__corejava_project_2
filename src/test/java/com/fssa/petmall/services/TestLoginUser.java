package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;

public class TestLoginUser {

	public static void main(String[] args) {

		User user1 = new User("acker4@gmail.com","Kotie@123");
		UserService userService = new UserService();

		try {
			userService.LoginUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestValidUser() throws ServiceException {
		User user1 = new User("acker4@gmail.com","Kotie@123");
		assertTrue(UserService.LoginUser(user1));
	}
	
	@Test
	public void TestInValidUser() throws ServiceException {
		User user1 = new User("acker4@gmail.com","Hacke@123");
		assertFalse(UserService.LoginUser(user1));
	}
	
}
