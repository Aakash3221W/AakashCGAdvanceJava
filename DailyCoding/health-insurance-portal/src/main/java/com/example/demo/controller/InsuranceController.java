package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Customer;

@Controller
public class InsuranceController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration"; 
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        List<String> plans = Arrays.asList("Basic Health Plan", "Premium Health Plan", "Family Coverage Plan");
        model.addAttribute("plans", plans);
        model.addAttribute("name", customer.getName());
        return "plan-list";
    }

    @GetMapping("/apply")
    public String apply(@RequestParam String planName, Model model) {
        model.addAttribute("selectedPlan", planName);
        model.addAttribute("status", "Pending"); 
        return "confirmation";
    }
    @GetMapping("/status")
    public String viewStatus(@RequestParam String planName, Model model) {
        model.addAttribute("selectedPlan", planName);
        
        // In a real scenario, you'd fetch this from a database
        // For now, we mock the logic:
        String mockStatus = "Pending"; 
        model.addAttribute("status", mockStatus);
        
        return "status";
    }
}