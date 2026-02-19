package com.example.demo.Exceptions;

public class CannotUpdateEmployeeIdException extends RuntimeException {
	
	public CannotUpdateEmployeeIdException(String message) {
		super(message);
	}

}
