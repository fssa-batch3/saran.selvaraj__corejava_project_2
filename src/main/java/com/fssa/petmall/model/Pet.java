package com.fssa.petmall.model;



public class Pet {
	private int uniqueID;

	private String petimageurl;
	private String realName;
    private String personalName;
    private String dob;
    private String specialTalent;
    private String behavior;
    private String price;
    private String mobileNumber;
    private String vaccinationCertificate;
    private String soldUserEmail;

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

    public Pet(int uniqueID, String realName, String price, String petimageurl, String personalName, String dob,
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
    	this.soldUserEmail = soldUserEmail;
	}
    public Pet(int uniqueID, String realName, String price, String petimageurl, String personalName, String dob,
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
    	this.soldUserEmail = soldUserEmail;
	}
    public Pet( String realName, String price, String petimageurl, String personalName, String dob,
			String specialTalent, String behavior, String mobileNumber, String vaccinationCertificate,String soldUserEmail) {

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

    public Pet() {
	}

	public String getsoldUserEmail() {
    	return soldUserEmail;
    }
    public void  setsoldUserEmail(String soldUserEmail) {
    	this.soldUserEmail = soldUserEmail;
    }
    public int getuniqueID() {
    	return uniqueID;
    }
    public void  setuniqueID(int uniqueID) {
    	this.uniqueID = uniqueID;
    }
	public String getpetimageurl() {
    	return petimageurl;
    }
    public void setpetimageurl(String petimageurl) {
    	this.petimageurl=petimageurl;
    }
    // Getter and Setter for Real Name
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
    	this.realName = realName;
    }

    // Getter and Setter for Personal Name (Nick name)
    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
    	this.personalName = personalName;
    }

    // Getter and Setter for DOB
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
    	this.dob = dob;
    }

    // Getter and Setter for Special Talent
    public String getSpecialTalent() {
        return specialTalent;
    }

    public void setSpecialTalent(String specialTalent) {
    	this.specialTalent = specialTalent;
    }

    // Getter and Setter for Behavior
    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
    	this.behavior = behavior;
    }

    // Getter and Setter for Pet Price
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
    	this.price = price;
    }

    // Getter and Setter for Mobile Number
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
    	this.mobileNumber = mobileNumber;
    }

    // Getter and Setter for Vaccination Certificate
    public String getVaccinationCertificate() {
        return vaccinationCertificate;
    }

    public void setVaccinationCertificate(String vaccinationCertificate) {
    	this.vaccinationCertificate = vaccinationCertificate;
    }


	@Override
	public String toString() {
		return "Pet [uniqueID=" + uniqueID + ", petimageurl=" + petimageurl + ", realName=" + realName
				+ ", personalName=" + personalName + ", dob=" + dob + ", specialTalent=" + specialTalent + ", behavior="
				+ behavior + ", price=" + price + ", mobileNumber=" + mobileNumber + ", vaccinationCertificate="
				+ vaccinationCertificate + ", soldUserEmail=" + soldUserEmail + "]";
	}






}