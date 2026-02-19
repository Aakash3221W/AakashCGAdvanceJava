package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BasketballCoach implements Coach{
	@Override
	public String getDailyWorkout() {
		return "Practice your shooting for 30 minutes";
	}
	
}
