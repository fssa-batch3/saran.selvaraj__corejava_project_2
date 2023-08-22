package com.fssa.petmall.model;


public class User {

	private int userID;
	private String first_name;
	public String last_name;
	private String gender;
	private String Phone_number;
	private String date_of_birth;
	public String email;
	public String password;
	
	
	//register
	public User(String first_name,String last_name, String gender , String Phone_number , String date_of_birth, String email, String password) {
		super();
		this.userID = userID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.Phone_number = Phone_number;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.password = password;
		
	}
	
	//update
	public User(String gender, String Phone_number , String date_of_birth) {
		super();
		this.gender = gender;
		this.Phone_number = Phone_number;
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
		return "UserID: " + userID + "First_name: " + first_name +"last_name"+last_name+ "gender: " + gender + "Phone_number: " + Phone_number + "date_of_birth: " + date_of_birth + "Email: " + email + " Password: " + password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getfirst_name() {
		return first_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getlast_name() {
		return last_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String Phone_number) {
		this.Phone_number = Phone_number;
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
