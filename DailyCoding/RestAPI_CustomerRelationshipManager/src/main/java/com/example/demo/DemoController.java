package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {
	
	StudentDAO studentDAO;
	
	@Autowired
	public DemoController(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, welcome to the Customer Relationship Manager API!";
	}
	
	@GetMapping("/StudentList")
	public List<Student> giveAllStudentData(){
		return studentDAO.getAllStudents();
	}
	
	@GetMapping("/Student/{firstName}")
	public Student findStundentByFirstName(@PathVariable String firstName) {
		return studentDAO.getStudentByIFirstName(firstName);
	}
	
	// To Make this method work, we need to create a class named StudentErrorResponse and another class named StudentNotFoundException
	//	To handle the exception gobally for all the methods in this controller, we can create another class named StudentExceptionHandler 
	//  and move this method to that class and annotate that class with @ControllerAdvice so the exception handling will be for all controllers
	// in the application
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
//			StudentErrorResponse error = new StudentErrorResponse();
//			error.setStatus(HttpStatus.NOT_FOUND.value());
//			error.setMessage(e.getMessage());
//			error.setTimeStamp(System.currentTimeMillis());
//			
//			return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
//	}

}
