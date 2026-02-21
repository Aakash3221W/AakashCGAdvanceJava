package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DAO.CustomerDAO;
import com.example.demo.Entity.Address;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Order;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerDAO customerDAO) {
		return runner -> {
			// You can perform operations with the DAOs here
			// For example, you can create and save a new product, customer, or address
			
			//Step 1 - Make a Customer
//			crateCustomer(customerDAO);
			
			//Step 2 - Reading the customer details
//			getCustomerDetails(customerDAO);
			
			//Step 3 - Update the customer details
//			 updateCustomerDetails(customerDAO);
			
			 //Step 4 - Delete the customer details
//			 deleteCustomerDetails(customerDAO);
		};
	}

	private void deleteCustomerDetails(CustomerDAO customerDAO) {
		Long customerId = 1L; // Assuming you want to delete the customer with ID 1
		customerDAO.deleteCustomer(customerId);
		System.out.println("Deleted customer with ID: " + customerId);
		
		
	}

	private void updateCustomerDetails(CustomerDAO customerDAO) {
		Long customerId = 1L; // Assuming you want to update the customer with ID 1
		Customer customer = customerDAO.findCustomerById(customerId);
		if (customer != null) {
			customer.setPhone("9876543210"); // Update the phone number
		    customerDAO.updateCustomer(customer); // Save the updated customer
		    System.out.println("Updated Customer Details:");
		    System.out.println(customer);
		} else {
		    System.out.println("Customer with ID " + customerId + " not found.");
		}
		
	}

	private void getCustomerDetails(CustomerDAO customerDAO) {
		Long customerId = 1L; // Assuming you want to fetch the customer with ID 1
		Customer customer = customerDAO.findCustomerById(customerId);
		System.out.println("Customer Details:");
		System.out.println(customer);
		
		
		
	}

	private void crateCustomer(CustomerDAO customerDAO) {
		// Create a new address
		Address address = new Address("123 Main St", "Springfield", "62701");
		 // Create a new customer
		Customer customer = new Customer("John", "John@gamil.com","9817654321");
		 // Set the address for the customer
		customer.setAddress(address);
		//Only saving the customer will also save the address because of the cascade settings in the Customer entity
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order("Order 1", 100.0);
		Order order2 = new Order("Order 2", 200.0);
		orders.add(order1);
		orders.add(order2);
		customer.setOrders(orders);
		// Save the customer (which will also save the address and orders due to cascading)
		
		customerDAO.saveCustomer(customer);	
		 System.out.println("Customer created: " + customer);
		 
	}

}
