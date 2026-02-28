package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        // Check if product already exists in cart to update quantity instead of adding new line
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
        return cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
    public void updateQuantity(Long productId, int change) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productId)) {
                int newQty = item.getQuantity() + change;
                if (newQty <= 0) {
                    cartItems.remove(item);
                } else {
                    item.setQuantity(newQty);
                }
                return;
            }
        }
    }
}
