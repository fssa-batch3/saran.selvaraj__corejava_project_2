package com.fssa.petmall.model;

public class User {

	private int userID;
	private int id;
	private String address;
	private int isDeleted;
	private int isDefault;
	public String email;
	private String firstname;
	public String lastname;
	private String gender;
	private String Phonenumber;
	private String dateofbirth;
	public String password;
	public int isdeleted;
	


	//register
	public User(String firstname,String lastname, String gender , String Phonenumber , String dateofbirth, String email, String password) {


		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.Phonenumber = Phonenumber;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.password = password;

	}
	public User(String firstname,String lastname, String gender , String Phonenumber , String dateofbirth) {


		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.Phonenumber = Phonenumber;
		this.dateofbirth = dateofbirth;

	}
	//update
	public User(int userID,String firstname,String lastname, String gender , String Phonenumber , String dateofbirth,int isdeleted) {

		this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.Phonenumber = Phonenumber;
		this.dateofbirth = dateofbirth;
		this.isdeleted = isdeleted;
	}

	//delete
		public User(int userID) {
			super();
			this.userID = userID;
		}
		public User(String address) {
			super();
			this.address = address;
		}

	//login
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(int id,String address, String email) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
	}

	public User() {
	}
	@Override
	public String toString() {
		return "UserID: " + userID + "First_name: " + firstname +"last_name"+lastname+ "gender: " + gender + "Phone_number: " + Phonenumber + "date_of_birth: " + dateofbirth + "Email: " + email + " Password: " + password;
	}

	public int getisDefault() {
		return isDefault;
	}
	public void setisDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	public int getisDeleted() {
		return isDeleted;
	}
	public void setisDeleted(int isDeleted) {
		this.isDeleted = isdeleted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIsDeleted() {
		return isdeleted;
	}
	public void setIsDeleted(int is_deleted) {
		this.isdeleted = is_deleted;
	}
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getfirst_name() {
		return firstname;
	}

	public void setfirst_name(String first_name) {
		this.firstname = first_name;
	}

	public String getlast_name() {
		return lastname;
	}

	public void setlast_name(String last_name) {
		this.lastname = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return Phonenumber;
	}

	public void setPhone_number(String Phone_number) {
		this.Phonenumber = Phone_number;
	}

	public String getDate_of_birth() {
		return dateofbirth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.dateofbirth = date_of_birth;
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
