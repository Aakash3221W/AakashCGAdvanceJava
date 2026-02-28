package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.entity.Product;
import com.example.demo.service.CartService;

class CartServiceTest {

    private CartService cartService;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        testProduct = new Product(1L, "Test Item", 100.00);
    }

    @Test
    void testAddToCart_NewItem() {
        cartService.addToCart(testProduct, 2);
        
        assertEquals(1, cartService.getCartItems().size());
        assertEquals(200.00, cartService.getTotalAmount());
    }

    @Test
    void testAddToCart_ExistingItem_IncreasesQuantity() {
        cartService.addToCart(testProduct, 1);
        cartService.addToCart(testProduct, 2); // Add more of the same

        assertEquals(1, cartService.getCartItems().size(), "Should not add new row for same product");
        assertEquals(3, cartService.getCartItems().get(0).getQuantity());
    }

    @Test
    void testUpdateQuantity_Increase() {
        cartService.addToCart(testProduct, 1);
        cartService.updateQuantity(1L, 1); // +1
        
        assertEquals(2, cartService.getCartItems().get(0).getQuantity());
    }

    @Test
    void testUpdateQuantity_DecreaseToRemove() {
        cartService.addToCart(testProduct, 1);
        cartService.updateQuantity(1L, -1); // Decrease to 0
        
        assertTrue(cartService.getCartItems().isEmpty(), "Item should be removed when quantity hits 0");
    }

    @Test
    void testClearCart() {
        cartService.addToCart(testProduct, 5);
        cartService.clearCart();
        
        assertEquals(0, cartService.getCartItems().size());
        assertEquals(0.0, cartService.getTotalAmount());
    }
}
