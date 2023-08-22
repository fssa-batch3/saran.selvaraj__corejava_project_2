package com.fssa.petmall.validation;

import java.util.regex.Pattern;

public class PetValidator {

	
	public static boolean validatePetName(String name) {
		boolean match = false;
		try {
			String regex = "^[A-Za-z0-9_]{3,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				System.out.println("The Pet name is valid.");
			} else {
				System.out.println("Pet name is not valid");
			}
		} catch (Exception e) {
			System.out.println("Pet name is not valid");
		}
		return match;
	}
	public static boolean validatePetPrice(String name) {
		boolean match = false;
		try {
			String regex = "^[1-9]{1,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				System.out.println("The Pet Price is valid.");
			} else {
				System.out.println("Pet Price is not valid");
			}
		} catch (Exception e) {
			System.out.println("Pet Price is not valid");
		}
		return match;
	}
	
	
}
