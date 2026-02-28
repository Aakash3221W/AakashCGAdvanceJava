package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    // 1. Display the Product Catalog
    @GetMapping("/products")
    public String viewProducts(Model model) {
        // Send the list of products to the "products.html" Thymeleaf page
        model.addAttribute("productList", productService.getAllProducts());
        return "products"; 
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            cartService.addToCart(product, quantity);
        }
        return "redirect:/products";
    }
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalAmount", cartService.getTotalAmount());
        return "cart";
    }
    
 // In CartController.java

    @PostMapping("/updateCart")
    public String updateCart(@RequestParam Long productId, @RequestParam int change) {
        cartService.updateQuantity(productId, change);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", cartService.getTotalAmount());
        cartService.clearCart(); // Empty the cart after purchase
        return "checkout";
    }
}