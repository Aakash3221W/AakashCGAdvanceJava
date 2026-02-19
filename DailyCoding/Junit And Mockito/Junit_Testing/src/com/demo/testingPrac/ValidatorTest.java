package com.demo.testingPrac;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidatorTest {
	
	@Test
	public void validateNameTest1() {
		Validator validator = new Validator();
		assertTrue(validator.validateName("Sam Johns"));
	}
	@Test
	public void validateNameTest2() {
		Validator validator = new Validator();
		assertTrue(validator.validateName("Johnathan"));
	}
	@Test
	public void validationAgeTest1() {
		Validator validator = new Validator();
		assertTrue(validator.validateAge(18));
	}
	@Test
	public void validationAgeTest2() {
		Validator validator = new Validator();
		assertFalse(validator.validateAge(17));
	}
	@Test
	public void validateInvalidNameTest() {
		Employee emp = new Employee("Maria", 25,2000);
		Validator validator = new Validator();
		try {
			validator.validate(emp);
		} catch (InvalidNameException e) {
			assertEquals("Name must be more than 8 characters", e.getMessage());
		} catch (InvalidAgeException e) {
			fail("Expected InvalidNameException, but got InvalidAgeException");
		}
	}
	@Test
	public void validateInvalidAgeTest() {
		Employee emp = new Employee("Maria Francis",17,2000);
		Validator validator = new Validator();
		try {
			validator.validate(emp);
		} catch (InvalidNameException e) {
			fail("Expected InvalidAgeException, but got InvalidNameException");
		} catch (InvalidAgeException e) {
			assertEquals("Age must be between 18 and 60", e.getMessage());
		}
	}
	@Test
	public void validateValidEmployeeTest() {
		Employee emp = new Employee("Maria Francis",18,2000);
		assertEquals(25440, emp.calculateAnnualSalary(),0.01);

		}
	
}
