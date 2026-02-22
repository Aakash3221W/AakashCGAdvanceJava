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
	
	// when you try the code try to change id based on data base generated id and change in the code accordingly
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			 createInstructorWithCourses(appDAO);
//			getInstructorWithCourses(appDAO);
			 
//			updateInstructor(appDAO);

//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
//			deleteCourse(appDAO);
//			deleteInstructorDetail(appDAO);
			 
		};
	}

private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 12;
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Deleted InstructorDetail with id: " + theId);
		
	}

private void deleteCourse(AppDAO appDAO) {
		int theId = 7;
		appDAO.deleteCourseById(theId);
		System.out.println("Deleted Course with id: " + theId);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 11;
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted Instructor with id: " + theId);
		
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 11;
		Instructor temp = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + temp);
		temp.setLastName("Kumar");
		appDAO.updateInstructer(temp);	
		System.out.println("Updated Instructor" );
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 9;
		Course temp = appDAO.findCourseById(theId);
		System.out.println("tempCourse: " + temp);
		temp.setTitle("Game dev with Unity");
		appDAO.updateCourse(temp);
		System.out.println("Updated Course" );
		
		
	}

	private void getInstructorWithCourses(AppDAO appDAO) {
		int theId = 11;
		Instructor temp = appDAO.findInstructorWithCourses(theId);
		System.out.println("tempInstructor: " + temp);
		System.out.println("the associated courses: " + temp.getCourses());
		
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Sumit","Gupta","Arman@gmail.com");
		InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.Gupta.com","Loves Play Games");
		List<Course> courses = new ArrayList<>();
		courses.add(new Course("Game dev"));
		courses.add(new Course("c#"));
		courses.add(new Course("Unity"));
		
		
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		for(Course c : courses) {
			tempInstructor.add(c);
		}
		
		appDAO.save(tempInstructor);
	}
	
	

}
