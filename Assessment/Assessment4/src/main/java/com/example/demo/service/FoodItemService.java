package com.example.demo.service;

import com.example.demo.dto.FoodItemDTO;
import com.example.demo.entity.FoodItem;
import com.example.demo.repository.FoodItemRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public FoodItemDTO addFoodItem(Long restaurantId, FoodItemDTO foodItemDTO) {
        // Verify restaurant exists or throw custom exception [cite: 42, 43]
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new ResourceNotFoundException("Restaurant not found with id: " + restaurantId);
        }

        FoodItem foodItem = new FoodItem(
            foodItemDTO.getName(),
            foodItemDTO.getPrice(),
            foodItemDTO.getCategory(),
            restaurantId
        );
        FoodItem saved = foodItemRepository.save(foodItem);
        foodItemDTO.setId(saved.getId());
        return foodItemDTO;
    }

    public List<FoodItem> getFoodItemsByRestaurant(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}