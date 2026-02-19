package com.demo.testingPrac;

public class LoginValidation {
	String username = "admin";// Default username
	String password = "password123";// Default password
	
	public boolean validateLogin(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
}
