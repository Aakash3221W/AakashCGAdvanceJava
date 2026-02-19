package com.demo.testingPrac;

public class Validator {
	
	public boolean validateName(String name){
		
		return name.length()>8;
	}
	public boolean validateAge(int age) {
		return age >= 18 && age <= 60;
	}
	public boolean validate(Employee emp) throws InvalidNameException, InvalidAgeException {
			if(!validateName(emp.getName())) {
				throw new InvalidNameException("Name must be more than 8 characters");
			}
			if(!validateAge(emp.getAge())) {
				throw new InvalidAgeException("Age must be between 18 and 60");
			}
			return true;
	}
	

}
