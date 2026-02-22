package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.AppDAO;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.Instructor;
import com.example.demo.Entity.InstructorDetails;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			
//			 createInstructorWithCourses(appDAO);
			 getInstructorWithCourses(appDAO);
		};
	}

	private void getInstructorWithCourses(AppDAO appDAO) {
		int theId = 7;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Arman","Singh","Arman@gmail.com");
		InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.Arman.com","Loves to code");
		List<Course> courses = new ArrayList<>();
		courses.add(new Course("Java"));
		courses.add(new Course("Python"));
		courses.add(new Course("C++"));
		
		
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		for(Course c : courses) {
			tempInstructor.add(c);
			c.setInstructor(tempInstructor);
		}
		
		appDAO.save(tempInstructor);
	}
	
	

}
