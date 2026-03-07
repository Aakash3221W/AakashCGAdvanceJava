package com.example.demo.repository;

import com.example.demo.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    // Custom method to fetch items for a specific restaurant
    List<FoodItem> findByRestaurantId(Long restaurantId);
}