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

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// when you try the code try to change id based on data base generated id and change in the code accordingly
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			
//			createCouseAndReviews(appDAO);
//			getCourseAndReviews(appDAO);
			
//			addReviewInExistingCourse(appDAO);
			
//			deleteCourseAndReviews(appDAO);

			 
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		
		int theId=10;
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
		
	}

	private void addReviewInExistingCourse(AppDAO appDAO) {
		
		int theId=10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
		
		System.out.println("Course: "+tempCourse);
		
		// add more reviews
		tempCourse.addReview(new Review("I love this course!"));
		tempCourse.addReview(new Review("This course is so bad!"));
		
		appDAO.updateCourse(tempCourse);
		
		System.out.println("Course: "+tempCourse);
		System.out.println("Reviews: "+tempCourse.getReviews());
		
	}

	private void getCourseAndReviews(AppDAO appDAO) {
		
		int theId=10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
		
		System.out.println("Course: "+tempCourse);
		
		System.out.println("Reviews: "+tempCourse.getReviews());
		
	}

	private void createCouseAndReviews(AppDAO appDAO) {
		
		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		
		// add some reviews
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
		
		// save the course ... and leverage the cascade all :-)
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		appDAO.save(tempCourse);
		
		System.out.println("Done!");
		
	}


}
	
	


