package com.example.demo;


import com.example.demo.entity.Book;
import com.example.demo.entity.Member;
import com.example.demo.service.BookService;
import com.example.demo.service.LibraryService;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {

    @Mock
    private BookService bookService;

    @Mock
    private MemberService memberService;

    @InjectMocks
    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIssueBook_Success() {
        Long memberId = 1L;
        Long bookId = 101L;
        Member mockMember = new Member(memberId, "John Doe", "john@example.com");
        Book mockBook = new Book(bookId, "Spring Boot Guide", "Author A");
        mockBook.setAvailable(true); 

        when(memberService.getMemberById(memberId)).thenReturn(mockMember); 
        when(bookService.getBookById(bookId)).thenReturn(mockBook);


        libraryService.issueBook(memberId, bookId);


        assertFalse(mockBook.isAvailable(), "Book should be marked as unavailable after issue");
        verify(memberService, times(1)).getMemberById(memberId);
        verify(bookService, times(1)).getBookById(bookId);
    }

    @Test
    void testIssueBook_Fail_AlreadyIssued() {

        Long memberId = 1L;
        Long bookId = 101L;
        Member mockMember = new Member(memberId, "John Doe", "john@example.com");
        Book mockBook = new Book(bookId, "Spring Boot Guide", "Author A");
        mockBook.setAvailable(false); 

        when(memberService.getMemberById(memberId)).thenReturn(mockMember);
        when(bookService.getBookById(bookId)).thenReturn(mockBook);

       
        libraryService.issueBook(memberId, bookId);

       
        assertFalse(mockBook.isAvailable(), "Book status should remain false");
    }

    @Test
    void testReturnBook_Success() {
        Long bookId = 101L;
        Book mockBook = new Book(bookId, "Spring Boot Guide", "Author A");
        mockBook.setAvailable(false); // Book is currently out

        when(bookService.getBookById(bookId)).thenReturn(mockBook);

  
        libraryService.returnBook(1L, bookId);

        assertTrue(mockBook.isAvailable(), "Book should be marked as available after return [cite: 46]");
        verify(bookService, times(1)).getBookById(bookId);
    }
}
