package com.example.demo.entity;

public class Product {
    private Long id;
    private String name;
    private double price;

    // Constructors
    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}