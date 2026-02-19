package com.demo.paramerterizedTest;
import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class UserTest {

	static  Stream<Arguments> validUserData() {
	        return Stream.of(
	            Arguments.of(new User("Aakash Singh",25),true),
	            Arguments.of(new User("Johnathan",30),true),
	            Arguments.of(new User("Emily stock",22),true),
	            Arguments.of(new User("Michael james",35),true)
	      );
	  }
	static  Stream<Arguments> invalidUserData() {
        return Stream.of(
            Arguments.of(new User("Sam",25),false),
			Arguments.of(new User("John",30),false),
			Arguments.of(new User("Emily",22),false),
			Arguments.of(new User("Michael",35),false)
      );
  }
	
	@ParameterizedTest
	@MethodSource("validUserData")
	public void shouldVerifyAllUser(User user, boolean expected) {
		assertEquals(expected, user.validateUser());
	}
	@ParameterizedTest
	@MethodSource("invalidUserData")
	public void shouldNotVerifyInvalidUser(User user, boolean expected) {
		assertEquals(expected, user.validateUser());
	}
	static Stream<Arguments> invalidUserExceptionData() {
		return Stream.of(
			Arguments.of(new User("Sam",25)),
			Arguments.of(new User("John",30)),
			Arguments.of(new User("Emily",22)),
			Arguments.of(new User("Michael sam",17))
	  );
  }
	@ParameterizedTest
	@MethodSource("invalidUserExceptionData")
	public void shouldThrowInvalidUserException(User user) {
		assertThrows(InvalidUserException.class, () -> user.validate());
	}   
	
	
	@ParameterizedTest
	@CsvSource({
	    "Aakash Singh, 25",
	    "Johnathan, 30",
	    "Emily stock, 22",
	    "Michael james, 35"
	})
	public void shouldVerifyUserWithCsvSource(String name, int age) {
	    User user = new User(name, age);
	    assertTrue(user.validateUser());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "TestData.csv", numLinesToSkip = 0)
	public void shouldVerifyUserWithCsvFileSource(String name, int age) {
	    User user = new User(name, age);
	    assertTrue(user.validateUser());
	}
	
}
