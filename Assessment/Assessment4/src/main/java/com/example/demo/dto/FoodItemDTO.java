package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class FoodItemDTO {
    private Long id;

    @NotBlank(message = "Food name is mandatory")
    private String name;

    @Positive(message = "Price must be a positive value")
    private Double price;

    private String category;

    public FoodItemDTO() {
        super();
    }

    public FoodItemDTO(Long id, String name, Double price, String category) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}