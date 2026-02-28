package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

import java.util.List;

import java.util.ArrayList;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        // Predefining data as per project requirements
        products.add(new Product(1L, "Laptop", 850.00));
        products.add(new Product(2L, "Smartphone", 500.00));
        products.add(new Product(3L, "Headphones", 150.00));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
