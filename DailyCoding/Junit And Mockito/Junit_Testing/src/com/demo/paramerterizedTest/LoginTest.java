package com.demo.paramerterizedTest;
import static org.junit.Assert.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
public class LoginTest {
	@ParameterizedTest
	@CsvFileSource(resources = "loginData.csv", numLinesToSkip = 0)
	public void shouldValidateLogin(String username, String password, boolean expected) {
	    if ("null".equals(username)) username = null;
	    if ("null".equals(password)) password = null;
		
		Login login = new Login(username, password);
		assertEquals(expected, login.validateLogin());
	}
	
}
