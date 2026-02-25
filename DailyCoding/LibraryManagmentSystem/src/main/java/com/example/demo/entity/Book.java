package com.example.demo.entity;

public class Book {
    private Long id;
    private String title;
    private String author;
    private boolean available; 


    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true; 
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + ", Available=" + available + "]";
    }
}