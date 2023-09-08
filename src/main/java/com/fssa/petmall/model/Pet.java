package com.fssa.petmall.model;



public class Pet {
	private static String uniqueID;
	private static String petimageurl;
	private static String realName;
    private static String personalName;
    private static String dob;
    private static String specialTalent;
    private static String behavior;
    private static String price;
    private static String mobileNumber;
    private static String vaccinationCertificate;
    private static String soldUserEmail;

    public Pet( String petimageurl,String realName, String personalName, String dob, String specialTalent, String behavior, String price, String mobileNumber, String vaccinationCertificate) {
        Pet.petimageurl=petimageurl;
        Pet.realName = realName;
        Pet.personalName = personalName;
        Pet.dob = dob;
        Pet.specialTalent = specialTalent;
        Pet.behavior = behavior;
        Pet.price = price;
        Pet.mobileNumber = mobileNumber;
        Pet.vaccinationCertificate = vaccinationCertificate;
    }

    public Pet(String uniqueID, String realName, String price, String petimageurl, String personalName, String dob,
			String specialTalent, String behavior, String mobileNumber, String vaccinationCertificate,String soldUserEmail) {
    	Pet.uniqueID = uniqueID;
    	Pet.petimageurl=petimageurl;
    	Pet.realName = realName;
    	Pet.personalName = personalName;
    	Pet.dob = dob;
        Pet.specialTalent = specialTalent;
        Pet.behavior = behavior;
        Pet.price = price;
        Pet.mobileNumber = mobileNumber;
        Pet.vaccinationCertificate = vaccinationCertificate;
        Pet.soldUserEmail = soldUserEmail;
	}
    public Pet( String realName, String price, String petimageurl, String personalName, String dob,
			String specialTalent, String behavior, String mobileNumber, String vaccinationCertificate,String soldUserEmail) {
    	
    	Pet.petimageurl=petimageurl;
    	Pet.realName = realName;
    	Pet.personalName = personalName;
    	Pet.dob = dob;
    	Pet.specialTalent = specialTalent;
    	Pet.behavior = behavior;
    	Pet.price = price;
    	Pet.mobileNumber = mobileNumber;
    	Pet.vaccinationCertificate = vaccinationCertificate;
    	Pet.soldUserEmail=soldUserEmail;
	}
    
    public static String getsoldUserEmail() {
    	return soldUserEmail;
    }
    public void  setsoldUserEmail(String soldUserEmail) {
    	Pet.soldUserEmail = soldUserEmail;
    }
    public static String getuniqueID() {
    	return uniqueID;
    }
    public void  setuniqueID(String uniqueID) {
    	Pet.uniqueID = uniqueID;
    }
	public static String getpetimageurl() {
    	return petimageurl;
    }
    public void setpetimageurl(String petimageurl) {
    	Pet.petimageurl=petimageurl;
    }
    // Getter and Setter for Real Name
    public static String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
    	Pet.realName = realName;
    }

    // Getter and Setter for Personal Name (Nick name)
    public static String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
    	Pet.personalName = personalName;
    }

    // Getter and Setter for DOB
    public static String getDob() {
        return dob;
    }

    public void setDob(String dob) {
    	Pet.dob = dob;
    }

    // Getter and Setter for Special Talent
    public static String getSpecialTalent() {
        return specialTalent;
    }

    public void setSpecialTalent(String specialTalent) {
    	Pet.specialTalent = specialTalent;
    }

    // Getter and Setter for Behavior
    public static String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
    	Pet.behavior = behavior;
    }

    // Getter and Setter for Pet Price
    public static String getPrice() {
        return price;
    }

    public void setPrice(String price) {
    	Pet.price = price;
    }

    // Getter and Setter for Mobile Number
    public static String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
    	Pet.mobileNumber = mobileNumber;
    }

    // Getter and Setter for Vaccination Certificate
    public static String getVaccinationCertificate() {
        return vaccinationCertificate;
    }

    public void setVaccinationCertificate(String vaccinationCertificate) {
    	Pet.vaccinationCertificate = vaccinationCertificate;
    }
	

}