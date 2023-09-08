package com.fssa.petmall.validation;

import java.util.regex.Pattern;
import com.fssa.petmall.utills.*;

public class PetValidator {

	
	public static boolean validatePetName(String name) {
		boolean match = false;
		try {
			String regex = "^[A-Za-z0-9_]{3,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				Logger.debug("The Pet name is valid.");
			} else {
				Logger.debug("Pet name is not valid");
			}
		} catch (Exception e) {
			System.out.println("Pet name is not valid");
		}
		return match;
	}
	public static boolean validatePetPrice(String string) {
		boolean match = false;
		try {
			
			if (string != null) {
				match = true;
				Logger.debug("The Pet Price is valid.");
			} else {
				Logger.debug("Pet Price is not valid");
			}
		} catch (Exception e) {
			Logger.debug("Pet Price is not valid");
		}
		return match;
	}
	
	
}
