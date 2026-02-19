package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			findStudent(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			getAllTheStudentsDetails(studentDAO);
			
			getStudentWithSpecificMailFormat(studentDAO);
		};
		
		
	}

	private void getStudentWithSpecificMailFormat(StudentDAO studentDAO) {
		String mailFormat = "yahoo.com";
		List<Student> students  =  studentDAO.findByEmailFormat(mailFormat);
		for(Student s : students) {
			System.out.println(s);
		}
		
		
	}
	private void getAllTheStudentsDetails(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student s : students) {
			System.out.println(s);
		}
		
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1000;
		System.out.println("Deleting student with id: " + studentId);
		
		studentDAO.deleteById(studentId);
		
		System.out.println("Deleted student with id: " + studentId);
		 Student myStudent = studentDAO.findById(studentId);
		 System.out.println("Found the student: " + myStudent);
		
	}
	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1000;
		System.out.println("Updating student with id: " + studentId);
		Student tempStudent = new Student("Aakash", "si", "aakash@gmail.com");
		studentDAO.update(tempStudent, studentId);
		 System.out.println("Updated student: " + tempStudent);
		 
		 Student myStudent = studentDAO.findById(studentId);
		 System.out.println("Found the student: " + myStudent);
		
	}
	private void findStudent(StudentDAO studentDAO) {
		int studentId = 1000;
		System.out.println("Finding student with id: " + studentId);
		
		Student myStudent = studentDAO.findById(studentId);
		
		System.out.println("Found the student: " + myStudent);
		
	}
	private void createStudent(StudentDAO studentDAO) {
		
		
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("John", "Doe", "jon@gmail.com");
		
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 6 student objects...");
		List<Student> students = List.of(
			    new Student("John", "Doe", "john@gmail.com"),
			    new Student("Mary", "Public", "mary@gmail.com"),
			    new Student("Bonita", "Applebum", "bonita@yahoo.com"),
			    new Student("Chad", "Darby", "chad@outlook.in"),
			    new Student("Suzy", "Queue", "suzy@gmail.com"),
			    new Student("Harold", "Davis", "harold@yahoo.com")
			);
		
		for(Student tempStudent: students) {
			System.out.println("Saving student: " + tempStudent);
			studentDAO.save(tempStudent);
		}
	}
	
	
		
		
		

}
