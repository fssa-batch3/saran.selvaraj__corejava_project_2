package com.fssa.petmall.validation;

import java.util.regex.Pattern;

import com.fssa.petmall.utills.Logger;

public class PetValidator {


	public static boolean validatePetName(String name) {
		boolean match = false;
		try {
			String regex = "^[A-Za-z]{3,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				Logger.debug("The Pet name is valid.");
			} else {
				Logger.debug("Pet name is not valid");
			}
		} catch (Exception e) {
			System.out.println("Pet name is not validHI");
			e.printStackTrace();
		}
		return match;
	}
	public static boolean validatePetPrice(String price) {
		boolean match = false;
		try {

			int Price = Integer.parseInt(price);
			if (Price >= 0 ) {
				match = true;
				Logger.debug("The Pet Price is valid.");
			} else if(price.isEmpty()){
				Logger.debug("Pet Price should not be Null");
			}
		} catch (Exception e) {
			Logger.debug("Pet Price is not valid");
		}
		return match;
	}


}
