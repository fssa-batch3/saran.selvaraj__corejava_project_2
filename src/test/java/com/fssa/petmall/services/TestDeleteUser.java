package com.fssa.petmall.services;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.services.exception.ServiceException;

class TestDeleteUser {



	@Test
	void TestDeleteSuccess() throws ServiceException {
try {
		String email = "aravindh@gmail.com";
        assertTrue(UserService.deleteUser(email));
}catch (Exception e) {
	e.printStackTrace();
	fail();
}
	}

	@Test
	void TestDeleteFail() throws ServiceException {

		String email = "saran2005@gmail.com";
        assertFalse(UserService.deleteUser(email));
	}


}
