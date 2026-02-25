package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Member;

@Service
public class LibraryService {
    private final BookService bookService;
    private final MemberService memberService;

    public LibraryService(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void issueBook(Long memberId, Long bookId) {
        Member member = memberService.getMemberById(memberId);
        Book book = bookService.getBookById(bookId);


        if (member == null) {
            System.out.println("Error: Member not found!");
            return;
        }


        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' issued to " + member.getName());
        } else {
            System.out.println("Error: Book is either not found or already issued!");
        }
    }

    public void returnBook(Long memberId, Long bookId) {
        Book book = bookService.getBookById(bookId);

        if (book != null) {
            book.setAvailable(true); 
            System.out.println("Book '" + book.getTitle() + "' returned successfully.");
        } else {
            System.out.println("Error: Invalid Book ID.");
        }
    }
}
