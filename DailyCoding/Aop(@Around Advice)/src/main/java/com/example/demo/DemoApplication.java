package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.MembershipDAO;
import com.example.demo.service.TrafficFortuneService;

@SpringBootApplication
public class DemoApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	// uncomment the method calls in the CommandLineRunner to test the different methods in the 
	//AccountDAO and MembershipDAO interfaces. Each method demonstrates a different aspect of AOP
	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO,TrafficFortuneService theTrafficFortuneService) {
		return runner -> {

//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
			
//			demoTheAfterAdvice(accountDAO); // the after advice will run regardless of whether an exception is thrown or not
			
//			demoTheAroundAdviceHandleException(theTrafficFortuneService);
			
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}
	
	// do not freak out we are reThrowing The exception so server will stop since we are not Handling it
	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");

	}
	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");
		//toggle the tripWire to true or false to see the difference in the output when an exception is thrown or not
		boolean tripWire = false;
		//if false hange on it will work to simulate time there is sleep of 5 sec
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");

	}
	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			//toggle the tripWire to true or false to see the difference in the output when an exception is thrown or not
			boolean tripWire = false;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: demoTheAfterAdvice");
			System.out.println("----");
			System.out.println("Exception caught in main program: " + e);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
		
		
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// set the tripWire to true to simulate an exception being thrown in the findAccounts method
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
			System.out.println("----");
			System.out.println("Exception caught in main program: " + e);
		}
		
	}
	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	

	
	
	
	
	

}
