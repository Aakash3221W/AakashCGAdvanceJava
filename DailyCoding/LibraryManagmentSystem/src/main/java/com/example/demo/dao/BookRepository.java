package com.example.demo.dao;


import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

import java.util.ArrayList;
import java.util.List;

@Repository 
public class BookRepository {
    // In-memory collection to simulate a database table 
    private final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
