package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.BookService;
import com.example.demo.service.LibraryService;
import com.example.demo.service.MemberService;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MemberService memberService, BookService bookService, LibraryService libraryService) {
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("=== Library Management System ===");

            while (running) {
                System.out.println("\n1. Register Member\n2. Add Book\n3. Issue Book\n4. Return Book\n5. View Available Books\n6. Exit");
                System.out.print("Select an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.print("Enter Member Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Member Email: ");
                        String email = scanner.nextLine();
                        memberService.registerMember(name, email); 
                        break;
                    case 2:
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        bookService.addBook(title, author); 
                        break;
                    case 3:
                        System.out.print("Enter Member ID: ");
                        Long mId = scanner.nextLong();
                        System.out.print("Enter Book ID: ");
                        Long bId = scanner.nextLong();
                        libraryService.issueBook(mId, bId); 
                        break;
                    case 4:
                        System.out.print("Enter Member ID: ");
                        Long retMId = scanner.nextLong();
                        System.out.print("Enter Book ID: ");
                        Long retBId = scanner.nextLong();
                        libraryService.returnBook(retMId, retBId); 
                        break;
                    case 5:
                        System.out.println("Listing Available Books...");
                        bookService.getAvailableBooks().forEach(System.out::println); 
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting System..."); 
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
            scanner.close(); 
        };
    }
}