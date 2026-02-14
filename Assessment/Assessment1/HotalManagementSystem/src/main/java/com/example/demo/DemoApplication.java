package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookingDAO bookingDAO) {
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            boolean keepRunning = true;

            System.out.println("--- Hotel Delight Management System ---"); 

            while (keepRunning) {
                System.out.println("\n1. Add New Booking"); 
                System.out.println("2. View All Bookings"); 
                System.out.println("3. Update Booking"); 
                System.out.println("4. Delete Booking"); 
                System.out.println("5. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> createBookingUI(bookingDAO, scanner);
                    case 2 -> displayAllBookings(bookingDAO);
                    case 3 -> updateBookingUI(bookingDAO, scanner);
                    case 4 -> deleteBookingUI(bookingDAO, scanner);
                    case 5 -> keepRunning = false;
                    default -> System.out.println("Invalid option.");
                }
            }
            System.out.println("System closed.");
        };
    }

    private void createBookingUI(BookingDAO bookingDAO, Scanner scanner) {
        System.out.print("Enter Customer Name: "); 
        String name = scanner.nextLine();
        

        System.out.print("Enter Room Type (Standard/Deluxe/Suite): "); 
        String type = scanner.next().toLowerCase();

        System.out.print("Enter Check-in Date (YYYY-MM-DD): "); 
        String inDate = scanner.next();

        System.out.print("Enter Check-out Date (YYYY-MM-DD): "); 
        String outDate = scanner.next();

        Booking newBooking = new Booking(name, type, inDate, outDate); 
        bookingDAO.save(newBooking); 
        
        System.out.println("Booking saved! Total Amount: " + newBooking.getTotalAmount());
    }

    private void displayAllBookings(BookingDAO bookingDAO) {
        List<Booking> bookings = bookingDAO.findAll();
        System.out.println("\n--- Current Records ---");
        for (Booking b : bookings) {
            System.out.println(b.getBookingId() + ": " + b.getCustomerName() + 
                               " [" + b.getRoomType() + "] Total: " + b.getTotalAmount());
        }
    }

    private void updateBookingUI(BookingDAO bookingDAO, Scanner scanner) {
        System.out.print("Enter Booking ID to update: ");
        int id = scanner.nextInt();
        
        Booking existingBooking = bookingDAO.findById(id);
        
        if (existingBooking == null) {
			System.out.println("Booking ID not found.");
			return;
		}
        
        System.out.print("Enter New Room Type (Standard/Deluxe/Suite): "); 
        String type = scanner.next();
        existingBooking.setRoomType(type.toLowerCase());
        bookingDAO.update(existingBooking);
        System.out.println("Booking updated! New Total Amount: " + existingBooking.getTotalAmount());
        
        
    }

    private void deleteBookingUI(BookingDAO bookingDAO, Scanner scanner) {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        bookingDAO.deleteById(id);
        System.out.println("Record removed.");
    }
}