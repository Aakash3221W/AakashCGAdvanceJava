package com.demo.testingPrac;

public class AgeValidater {
	
	private Database database;
	
	
	public AgeValidater(Database database) {
		this.database = database;
	}
	
	void vaidateAge(int age) throws InvalidAgeException {
		if (age < 0){
			throw new InvalidAgeException("Age must be between 0 and 150");
		}
		database.saveAge(age);
	}
	
}
