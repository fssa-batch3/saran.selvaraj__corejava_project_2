package com.fssa.petmall.model;

public class Pet {

	public static int UniqueID;
	public static  String Real_name;
	public static int Price;
	public static String vaccination;
	
	public Pet(int UniqueID,String real_name,int Price,String Vaccination) {
		super();
		this.UniqueID = UniqueID;
		this.Real_name = Real_name;
		this.Price = Price;
		this.vaccination = Vaccination;
	}
	public static int getUniqueID() {
		return UniqueID;
	}

	public void setUniqueID(int uniqueID) {
		UniqueID = uniqueID;
	}

	public static String getReal_name() {
		return Real_name;
	}

	public void setReal_name(String real_name) {
		Real_name = real_name;
	}

	public static int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public static String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}
	
}
