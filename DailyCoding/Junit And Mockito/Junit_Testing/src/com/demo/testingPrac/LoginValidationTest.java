package com.demo.testingPrac;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LoginValidationTest {
	@Test
	public void testValidLogin() {
		LoginValidation login = new LoginValidation();
		assertTrue(login.validateLogin("admin", "password123"));
	}
	
	@Test
	public void testInvalidLogin() {
		LoginValidation login = new LoginValidation();
		assertTrue(!login.validateLogin("user", "pass"));
	}
}
