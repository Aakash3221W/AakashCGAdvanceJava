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
//			saveInstructor(appDAO);
			findInstructorById(appDAO);
		};
	}

	private void findInstructorById(AppDAO appDAO) {
		
		int id=1;
		Instructor instructor=appDAO.findInstructorById(id);
		System.out.println("Instructor found: "+instructor);
		
	}

	private void saveInstructor(AppDAO appDAO) {
		InstructorDetails instructorDetails=new InstructorDetails("http://www.youtube.com/abc","Guitar");
		
		Instructor instructor=new Instructor("John","Doe","john@gmail.com",instructorDetails);
		
		appDAO.save(instructor);
		System.out.println("Instructor saved: "+instructor);
		
	}
	

}
