package com.example.config_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.models.User;
import com.example.config_service.client.CarrentalsClient;

@RestController
@RefreshScope
public class PassengerController {
	
	@Autowired
	CarrentalsClient carrentalsClient;
	
	PassengerController(CarrentalsClient carrentalsClient) {
		this.carrentalsClient = carrentalsClient;
	}
	
	@Value("${custom.message}")
	private String message;

	@GetMapping("/msg")
	public String getMessage() {
		return message;
	}
	
	@GetMapping("/passengers")
	public List<User> getUser() {
		ArrayList<User> users = new ArrayList<>();
		
		users.add(new User("103U", "John Doe"));
		users.add(new User("104V", "Jane Smith"));
		users.add(new User("105W", "Alice Johnson"));
		users.add(new User("106X", "Bob Brown"));
		
		return users;
	}
	
	@GetMapping("/cars")
	public Object getCars() {
		return carrentalsClient.getCars();
	}

}
