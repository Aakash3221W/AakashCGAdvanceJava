package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.AppDAO;
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
//			 createInstructor(appDAO);

//			 findInstructor(appDAO);

//			 deleteInstructor(appDAO);

//			 findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor details id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Deleted instructor details id: " + theId);
		
		
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetails tempInstructorDetails = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetails: " + tempInstructorDetails);
		System.out.println("the associated instructor: " + tempInstructorDetails.getInstructor());
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted instructor id: " + theId);
		
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Chad","Darby","Chad.Darby@gmail.com");
		InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.luv2code.com/youtube","luv 2 code!!!");
		
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Saved instructor: " + tempInstructor);
	}

	
	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
	}
}
	


