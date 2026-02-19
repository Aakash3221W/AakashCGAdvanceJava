package com.demo.Day2Assessment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



public class UserServiceTest {
	@ParameterizedTest
	@CsvSource({
		"JohnDoe, password123",
		"JaneSmith, mySecurePass",
		
	})
	void shouldTakeValidUserDetails(String name, String password) {
		assertTrue(UserService.registerUser(name, password));
	}
		
	@ParameterizedTest
	@CsvSource({
		"'', password123",
		"null, password123",
		"JohnDoe, pass",
		
	})
	void shouldRejectInvalidUserDetails(String name, String password) {
		assertFalse(UserService.registerUser(name, password));
	}
	
	@ParameterizedTest
	@CsvSource({
		"JohnDoe, pass",
		"JaneSmith, 12345",
		
	})
	void shouldRejectWeakPassword(String name, String password) {
		assertFalse(UserService.registerUser(name, password));
	}
}
