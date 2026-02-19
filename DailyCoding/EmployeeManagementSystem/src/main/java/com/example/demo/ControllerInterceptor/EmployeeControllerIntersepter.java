package com.example.demo.ControllerInterceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Entity.EmployeeErrorReport;
import com.example.demo.Exceptions.CannotUpdateEmployeeIdException;
import com.example.demo.Exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeControllerIntersepter {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorReport> handleException(EmployeeNotFoundException e){
		EmployeeErrorReport error = new EmployeeErrorReport();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorReport>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorReport> handleException(CannotUpdateEmployeeIdException e){
		EmployeeErrorReport error = new EmployeeErrorReport();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorReport>(error,HttpStatus.BAD_REQUEST);
	}
	
}
