package com.fssa.petmall.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.petmall.model.User;
import com.fssa.petmall.services.UserService;
import com.fssa.petmall.services.exception.ServiceException;

public class TestRegisterUser {

    	public static void main(String[] args) {
    
    		 User user1 = new User("saran","selvaraj","Male" ,"9500320194","2004-12-26", "Hacker4@gmail.com","Kottnn@123");
    		 UserService userService = new UserService();
    		 System.out.println("Registration not successful! Error : Validation Failed Or User Already Exist");
    
    	}
		private User user1; 
    
    	@Test
    	public void testRegistrationSuccess() {
    		 UserService userService = new UserService();
    		 User user1 = new User("Kotti_784","kottiyan","Male" ,"9500320194","2004-12-26", "Ajmal@gmail.com","Kotie@123");
    		 try {
    
    		 assertTrue(UserService.registerUser(user1));
    		 }
    		 catch (ServiceException e) {
    		     
    			 System.out.println("Unable to register user");
    		 }
    		 
    	} 
    
    	@Test
    	public void testInvalidPassword() {
    
    		 UserService userService = new UserService();
    		 User user1 = new User("Kotti_784","yan","Male" ,"9500320194","2004-12-26", "hasadwacker4@gmail.com","Kotti@123");
    		 try {
    		    assertFalse(UserService.registerUser(user1));
    		 
    		 }catch (ServiceException e) {
//    		    e.printStackTrace();
    		    System.out.println("Unable to register user");
    		 }
    		    
    		 
         	 
    	}
    
    	 @Test
    	    public void testRegisterUserValid() {
    	        User user = new User("John", "Doe", "Male", "1234567890", "2000-01-01", "john@example.com", "password");
    	        try {
    	            assertTrue(UserService.registerUser(user));
    	        } catch (ServiceException e) {
    	            fail("Exception thrown: " + e.getMessage());
    	        }
    	    }

    	    @Test
    	    public void testRegisterUserInvalid() {
    	        User user = new User("John", "Doe", "Male", "1234567890", "2000-01-01", "john@example.com", "pass");
    	        try {
    	            assertFalse(UserService.registerUser(user));
    	        } catch (ServiceException e) {
    	            fail("Exception thrown: " + e.getMessage());
    	        }
    	    }
    	    

    	    @Test
    	    public void testRegisterUserNullUser() {
    	        try {
    	            UserService.registerUser(null); // This will cause a NullPointerException
    	            fail("Expected NullPointerException was not thrown");
    	        } catch (NullPointerException e) {
    	            // The exception is expected, so the test passes
    	        } catch (ServiceException e) {
    	            fail("Unexpected ServiceException thrown: " + e.getMessage());
    	        }
    	    }

}