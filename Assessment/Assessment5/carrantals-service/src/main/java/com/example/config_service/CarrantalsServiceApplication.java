package com.example.config_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarrantalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrantalsServiceApplication.class, args);
	}

}
