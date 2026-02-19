package com.demo.Day2Assessment;

public class UserService {
	
	static public boolean registerUser(String username, String password){
		username = username.trim();
		if(username == null || username.length()==0 || password.length()<8 || username.equals("null")) {
			return false;
		}
		return true;
	}

}
