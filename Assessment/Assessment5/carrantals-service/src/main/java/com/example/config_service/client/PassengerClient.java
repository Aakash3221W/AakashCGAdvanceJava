package com.example.config_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.common.models.User;

@FeignClient(name = "passenger-service",fallbackFactory = PassengerClientFallbackFactory.class)
public interface PassengerClient {
	
	@GetMapping("/passengers")
	 public List<User> getPassengers();

}
