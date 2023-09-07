package com.fssa.petmall.services;
import java.sql.SQLException;

import com.fssa.petmall.dao.UserDAO;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;
import com.fssa.petmall.validation.UserValidator;
import com.fssa.petmall.validation.exception.InvalidUserException;


public class UserService {

	public static boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getEmail(),user.getPassword());
		try {
		if(UserValidator.validateUser(user) && !userDAO.emailExist(user1)) { 
			if(userDAO.register(user)) {
				System.out.println(user.getfirst_name() + " Successfully Registered!");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	//update user
	public static boolean updateUser(User user , String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.update(user , email)) {
				System.out.println("User Details Successfully Updated!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	//delete user
	public static boolean deleteUser(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.delete(email)) {
				System.out.println("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public static boolean loginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.login(user)) {
				System.out.println("\n" + user.email + " Login Successful!");
				return true;
			} else {
				System.out.println("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
}
