package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.AppDAO;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.Review;
import com.example.demo.Entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// when you try the code try to change id based on data base generated id and change in the code accordingly
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			
//			createStudentAndCourses(appDAO);
//			getStudentAndCourses(appDAO);
//			 findCourseAndStudents(appDAO);
//			 addMoreCoursesForStudent(appDAO);
//			 deleteCourse(appDAO);
//			deleteStudent(appDAO);
			
			 
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		
		int theId=2;
		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
		
	}

	private void deleteCourse(AppDAO appDAO) {
		
		int theId=27;
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
		
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		
		int theId=2;
		Student tempStudent = appDAO.findStudentByIdWithCouses(theId);
		
		System.out.println("Student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		
		Course tempCourse1 = new Course("Python");
		Course tempCourse2 = new Course("Django");
		
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		
		appDAO.update(tempStudent);
		
		System.out.println("Done!");
		
		
		
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		
		int theId=25;
		Course tempCourse = appDAO.findCourseByIdWithStudents(theId);
		
		System.out.println("Course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
		
	}

	private void getStudentAndCourses(AppDAO appDAO) {
		
		int theId=2;
		Student tempStudent = appDAO.findStudentByIdWithCouses(theId);
		
		System.out.println("Student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		
	}

	private void createStudentAndCourses(AppDAO appDAO) {
		Course tempCourse1 = new Course("Spring Boot");
		
		Student tempStudent = new Student("Aakash", "Kumar", "aakash@gmail.com");
		Student tempStudent2 = new Student("Rohit", "Sharma", "Rohit@gmail.com");
		
		// save the student and leverage the cascade all
		
		System.out.println("Saving Course: "+tempCourse1);
		tempCourse1.addStudent(tempStudent);
		tempCourse1.addStudent(tempStudent2);
		
		appDAO.save(tempCourse1);
		System.out.println("Done!");
		
		
		
	}




}
	
	


