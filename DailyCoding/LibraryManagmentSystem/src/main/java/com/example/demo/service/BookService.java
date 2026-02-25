package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepository;
import com.example.demo.entity.Book;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AtomicLong idCounter = new AtomicLong(1);
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author) {
        Book book = new Book(idCounter.getAndIncrement(), title, author);
        bookRepository.save(book);
        System.out.println("Book added successfully: " + book);
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findAll().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
    
    public Book getBookById(Long id) {
        return bookRepository.findById(id);
    }
}
