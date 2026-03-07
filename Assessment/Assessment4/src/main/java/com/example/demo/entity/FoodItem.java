package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food_items")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; 
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price; 

    @Column(name = "category")
    private String category; 

    @Column(name = "restaurant_id")
    private Long restaurantId; 

    public FoodItem() {
        super();
    }

    public FoodItem(String name, Double price, String category, Long restaurantId) {
        super();
        this.name = name;
        this.price = price;
        this.category = category;
        this.restaurantId = restaurantId;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
}