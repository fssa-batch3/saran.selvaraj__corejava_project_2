package com.fssa.petmall.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.fssa.petmall.model.User;
import com.fssa.petmall.validation.exception.InvalidUserException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserValidator {
	
	// if three conditions valid then user valid
	public static boolean ValidateUser(User user) throws InvalidUserException {
		if(user != null && validateName(user.getfirst_name())&& validateName(user.getlast_name()) && validateEmail(user.getEmail()) 
				&& validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}


	public static boolean validateName(String name) {
		boolean match = false;
		try {
			String regex = "^[A-Za-z0-9_]{3,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				System.out.println("The user name is valid.");
			} else {
				System.out.println("user name is not valid");
			}
		} catch (Exception e) {
			System.out.println("user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;
		try {
			String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);
			if (match) {
				System.out.println("Valid password.");
			} else {
				System.out.println("Invalid password.");
			}
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				System.out.println("The email address is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return isMatch;
		

    }
	public static boolean validateDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            return false;
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Disable lenient parsing
        
        try {
            Date dob = dateFormat.parse(dateOfBirth);
            
            // Check if date of birth is in the past
            Date currentDate = new Date();
            if (dob.after(currentDate)) {
                return false;
            }
            
            return true;
        } catch (ParseException e) {
            return false; // Invalid date format
        }
    }
	
	public static boolean validateGender(String gender) {
        if (gender == null || gender.isEmpty()) {
            return false;
        }
        gender = gender.toLowerCase();
        return gender.equals("male") || gender.equals("female");
    }
	

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        // Regular expression pattern for a valid phone number (change as needed)
        String regex = "^[0-9]{10}$"; // Assuming a 10-digit phone number
        
        return Pattern.matches(regex, phoneNumber);
    }
}

