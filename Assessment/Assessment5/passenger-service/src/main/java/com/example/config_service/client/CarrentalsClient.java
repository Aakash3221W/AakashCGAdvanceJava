package com.example.config_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.common.models.Cars;

@FeignClient(name = "carrantals-service" , fallbackFactory = CarrentalsClientFallbackFactory.class)
public interface CarrentalsClient {
	
	@GetMapping("/cars")
	 public List<Cars> getCars();

}
