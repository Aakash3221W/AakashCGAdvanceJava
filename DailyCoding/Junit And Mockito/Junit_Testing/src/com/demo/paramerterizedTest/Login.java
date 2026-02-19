package com.demo.paramerterizedTest;

public class Login {
	String username;
	String password;
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
    public boolean validateLogin() {
        if (username == null || password == null) {
            return false;
        }
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        if (username.length() < 3 || password.length() < 6) {
            return false;
        }

        return true;
    }
	
}
