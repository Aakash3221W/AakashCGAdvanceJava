package com.example.config_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.models.Cars;
import com.example.common.models.User;
import com.example.config_service.client.PassengerClient;

@RestController
@RefreshScope
public class CarrantalsController {

	@Autowired
	PassengerClient passengerClient;
	
	CarrantalsController(PassengerClient passengerClient) {
		this.passengerClient = passengerClient;
	}
	
    @Value("${custom.message}")
    private String message;

    @GetMapping("/msg")
    public String getMessage() {
        return message;
    }
    
    @GetMapping("/cars")
    public List<Cars> getCars() {
    	ArrayList<Cars> cars = new ArrayList<>();
    	cars.add(new Cars("102A", "Toyota Camry", 2000.0));
    	cars.add(new Cars("103B", "Honda Accord", 1800.0));
    	cars.add(new Cars("104C", "Ford Mustang", 2500.0));
    	cars.add(new Cars("105D", "Chevrolet Malibu", 2200.0));
    	
    	return cars;
	}
    @GetMapping("/passengers")
    public List<User> getUsers() {
    	return passengerClient.getPassengers();
    	
	}

}
