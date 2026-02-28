package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import java.util.List;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertEquals(3, products.size(), "Should have 3 predefined products");
    }

    @Test
    void testGetProductById_ValidId() {
        Product product = productService.getProductById(1L);
        assertNotNull(product);
        assertEquals("Laptop", product.getName());
    }

    @Test
    void testGetProductById_InvalidId() {
        Product product = productService.getProductById(99L);
        assertNull(product, "Should return null for non-existent ID");
    }
}
