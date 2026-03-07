package com.example.demo.service;

import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.Restaurant;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Supports pagination with page and size parameters [cite: 47, 70]
    public Page<Restaurant> getAllRestaurants(int page, int size) {
        return restaurantRepository.findAll(PageRequest.of(page, size));
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant(
            restaurantDTO.getName(), 
            restaurantDTO.getLocation(), 
            restaurantDTO.getRating()
        );
        Restaurant saved = restaurantRepository.save(restaurant);
        restaurantDTO.setId(saved.getId());
        return restaurantDTO;
    }
}