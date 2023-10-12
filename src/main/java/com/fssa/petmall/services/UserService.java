package com.fssa.petmall.services;
import java.sql.SQLException;
import java.util.List;

import com.fssa.petmall.dao.PetDAO;
import com.fssa.petmall.dao.UserDAO;
import com.fssa.petmall.dao.exception.DAOException;
import com.fssa.petmall.model.Pet;
import com.fssa.petmall.model.User;
import com.fssa.petmall.services.exception.ServiceException;
import com.fssa.petmall.utills.Logger;
import com.fssa.petmall.utills.Utills;
import com.fssa.petmall.validation.UserValidator;
import com.fssa.petmall.validation.exception.InvalidUserException;


public class UserService {

	public boolean registerUser(User user) throws ServiceException{
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getEmail(),user.getPassword());
		
		try {
		if(UserValidator.validateUser(user) && !userDAO.emailExist(user1)) {
			if(userDAO.register(user)) {
				Logger.debug((user.getfirst_name() + " Successfully Registered!"));
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
				Logger.debug(("User Details Successfully Updated!"));
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
				Logger.debug("User Details Successfully Deleted!");
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
				Logger.debug("\n" + user.email + " Login Successful!");
				return true;
			} else {
				Logger.debug("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public User fetchUserIDByEmail(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = null;
		user1 = userDAO.fetchUserIDByEmail(email);
		Logger.debug(("User Details Successfully Updated!"));
		return user1;
	}
	
	public boolean createAddress(String email, String address) throws ServiceException{
		UserDAO userDAO = new UserDAO();
		try {		
			if(userDAO.createAddress(email,address)) {
				return true;
			} else {
				return false;
			}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public boolean updateAddress( String address,int id) throws ServiceException{
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.updateAddress(address,id)) {
				return true;
			} else {
				return false;
			}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public boolean deleteAddress(int id) throws ServiceException{
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.deleteAddress(id)) {
				return true;
			} else {
				return false;
			}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public List<User> listOfAddress(String email) throws ServiceException {
		List<User> list = null;
		try {
			list = UserDAO.listOfAddress(email);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}
	
	public List<User> getDefaultAddress(String email) throws ServiceException {
		List<User> list = null;
		try {
			list = UserDAO.getDefaultAddress(email);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}
	
	public boolean setDefaultAddress(int id) throws ServiceException{
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.setDefaultAddress(id)) {
				return true;
			} else {
				return false;
			}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public boolean removeDefaultAddress(String email) throws ServiceException{
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.removeDefaultAddress(email)) {
				return true;
			} else {
				return false;
			}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}

}
