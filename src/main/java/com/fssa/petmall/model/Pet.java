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
        this.petimageurl=petimageurl;
        this.realName = realName;
        this.personalName = personalName;
        this.dob = dob;
        this.specialTalent = specialTalent;
        this.behavior = behavior;
        this.price = price;
        this.mobileNumber = mobileNumber;
        this.vaccinationCertificate = vaccinationCertificate;
    }

    public Pet(String uniqueID, String realName, String price, String petimageurl, String personalName, String dob,
			String specialTalent, String behavior, String mobileNumber, String vaccinationCertificate) {
    	this.uniqueID = uniqueID;
		this.petimageurl=petimageurl;
        this.realName = realName;
        this.personalName = personalName;
        this.dob = dob;
        this.specialTalent = specialTalent;
        this.behavior = behavior;
        this.price = price;
        this.mobileNumber = mobileNumber;
        this.vaccinationCertificate = vaccinationCertificate;
	}
    public Pet(String uniqueID, String realName, String price, String petimageurl, String personalName, String dob,
			String specialTalent, String behavior, String mobileNumber, String vaccinationCertificate,String soldUserEmail) {
    	this.uniqueID = uniqueID;
		this.petimageurl=petimageurl;
        this.realName = realName;
        this.personalName = personalName;
        this.dob = dob;
        this.specialTalent = specialTalent;
        this.behavior = behavior;
        this.price = price;
        this.mobileNumber = mobileNumber;
        this.vaccinationCertificate = vaccinationCertificate;
        this.soldUserEmail=soldUserEmail;
	}
    
    public static String getsoldUserEmail() {
    	return soldUserEmail;
    }
    public void  setsoldUserEmail(String soldUserEmail) {
    	this.soldUserEmail = soldUserEmail;
    }
    public static String getuniqueID() {
    	return uniqueID;
    }
    public void  setuniqueID(String uniqueID) {
    	this.uniqueID = uniqueID;
    }
	public static String getpetimageurl() {
    	return petimageurl;
    }
    public void setpetimageurl(String petimageurl) {
    	this.petimageurl=petimageurl;
    }
    // Getter and Setter for Real Name
    public static String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    // Getter and Setter for Personal Name (Nick name)
    public static String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    // Getter and Setter for DOB
    public static String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // Getter and Setter for Special Talent
    public static String getSpecialTalent() {
        return specialTalent;
    }

    public void setSpecialTalent(String specialTalent) {
        this.specialTalent = specialTalent;
    }

    // Getter and Setter for Behavior
    public static String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    // Getter and Setter for Pet Price
    public static String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // Getter and Setter for Mobile Number
    public static String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Getter and Setter for Vaccination Certificate
    public static String getVaccinationCertificate() {
        return vaccinationCertificate;
    }

    public void setVaccinationCertificate(String vaccinationCertificate) {
        this.vaccinationCertificate = vaccinationCertificate;
    }
	

}