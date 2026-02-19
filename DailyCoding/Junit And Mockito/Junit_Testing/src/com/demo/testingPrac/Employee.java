package com.demo.testingPrac;

public class Employee {
	private String name;
	private int age;
	private double salary;
	
	
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setId(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double calculateAnnualSalary() {
		Validator validator = new Validator();
		if(!validator.validateAge(age))throw new IllegalArgumentException("Age must be between 18 and 60");
		
		if(age>=50) {
			return (salary * 12)*1.08;
		}else {
			return (salary * 12)*1.06;
		}
		

	}
}
