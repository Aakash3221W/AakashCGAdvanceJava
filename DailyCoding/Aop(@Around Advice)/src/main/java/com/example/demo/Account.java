package com.example.demo;


//this just a dummy class to test the pointcut expression with parameters
public class Account {
	   @Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}

	   public Account(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	   private String name;
	    private String level;


	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getLevel() {
	        return level;
	    }

	    public void setLevel(String level) {
	        this.level = level;
	    }

}
