package com.fssa.petmall.model;

public class User {

	private int userID;
	private String fisrtname;
	private String gender;
	private String mobile_number;
	private String date_of_birth;
	public String email;
	public String password;
	
	//register
	public User(String fisrtname, String gender , String mobile_number , String date_of_birth, String email, String password) {
		super();
		this.userID = userID;
		this.fisrtname = fisrtname;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.password = password;
	}
	
	//update
	public User(String gender, String mobile_number , String date_of_birth) {
		super();
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.date_of_birth = date_of_birth;
	}
	
	//delete
		public User(int userID) {
			super();
			this.userID = userID;
		}
	
	//login
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String toString() {
		return "UserID: " + userID + "username: " + fisrtname + "gender: " + gender + "mobile_number: " + mobile_number + "date_of_birth: " + date_of_birth + "Email: " + email + " Password: " + password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return fisrtname;
	}

	public void setUsername(String fisrtname) {
		this.fisrtname = fisrtname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
