package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FoodItemDTO;
import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.FoodItem;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.FoodItemService;
import com.example.demo.service.RestaurantService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping
("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired 
    private FoodItemService foodItemService;


    @GetMapping
    public ResponseEntity<Page<Restaurant>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(restaurantService.getAllRestaurants(page, size));
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RestaurantDTO> add(@Valid @RequestBody RestaurantDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.addRestaurant(dto));
    }

 
    @PostMapping("/{restaurantId}/fooditems")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FoodItemDTO> addFood(@PathVariable Long restaurantId, 
                                             @Valid @RequestBody FoodItemDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodItemService.addFoodItem(restaurantId, dto));
    }


    @GetMapping("/{restaurantId}/fooditems")
    public ResponseEntity<List<FoodItem>> getFood(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(foodItemService.getFoodItemsByRestaurant(restaurantId));
    }
}
