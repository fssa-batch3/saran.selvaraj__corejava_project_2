package com.fssa.petmall.utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utills {

	// Call the database connection
	public static Connection getConnection() {
		
		
		final String DB_URL;
		final String DB_USER;
		final String DB_PASSWORD;

//      DB_URL = System.getenv("DB_URL");
//      DB_USER = System.getenv("DB_USER");
//      DB_PASSWORD = System.getenv("DB_PASSWORD");
		
		
//      DB_URL = System.getenv("L_DB_URL");
//      DB_USER = System.getenv("L_DB_USER");
//      DB_PASSWORD = System.getenv("L_DB_PASSWORD");
		
		
		DB_URL = "jdbc:mysql://localhost:3306/pet_mall";
		DB_USER = "root";
		DB_PASSWORD = "123456";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Connect to Database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database Driver class Not found", e);
		}
	}
	
	
}
