package com.demo.paramerterizedTest;

public class User {
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	 public boolean validateUser() {
	        return name != null && name.length() > 8 && age >= 18 && age <= 60;
	 }
	 
	 public void validate() throws InvalidUserException {
	        if (name == null || name.length() <= 8) {
	            throw new InvalidUserException("Name must be more than 8 characters");
	        }
	        if (age < 18 || age > 60) {
	            throw new InvalidUserException("Age must be between 18 and 60");
	        }
	    }
}
