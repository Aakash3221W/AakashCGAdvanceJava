package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.MembershipDAO;

@SpringBootApplication
public class DemoApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	// uncomment the method calls in the CommandLineRunner to test the different methods in the 
	//AccountDAO and MembershipDAO interfaces. Each method demonstrates a different aspect of AOP
	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO , membershipDAO);

		};
	}
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
	}

	

	
	
	
	
	

}
