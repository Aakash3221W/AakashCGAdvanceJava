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
//			demoAddAccount(accountDAO, membershipDAO);
			
//			demoAddAccountWithParameter(accountDAO, membershipDAO);
			
//			demoAddAccountWithParameterAndReturnValue(accountDAO);
		};
	}
	
	private void demoAddAccountWithParameterAndReturnValue(AccountDAO accountDAO) {
		System.out.println("\n====>>> Calling addAccount() method with an Account parameter and return value");
		Boolean result = accountDAO.addAccount(new Account(), true);
		System.out.println("Result: " + result);
		
	}

	private void demoAddAccountWithParameter(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		System.out.println("\n====>>> Calling addAccount() method with an Account parameter");
		accountDAO.addAccount(new Account());
		System.out.println("\n====>>> Calling addMembership() method with an Account parameter");
		membershipDAO.addMembership(new Account());
		
	}

	private void demoAddAccount(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		System.out.println("\n====>>> Calling addAccount() method");
		accountDAO.addAccount();
		System.out.println("\n====>>> Calling addMembership() method");
		membershipDAO.addMembership();
	}
	
	
	
	
	

}
