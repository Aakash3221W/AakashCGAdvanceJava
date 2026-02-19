package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

	
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach();
	}
}
