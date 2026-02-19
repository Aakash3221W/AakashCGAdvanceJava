package com.demo.testingPrac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class FactorialCheckTest {
	@Test
	public void testFactorial() {
		FactorialCheck fc = new FactorialCheck();
		assertEquals(120, fc.factorial(5));
		assertEquals(1, fc.factorial(0));
	}
	
	@Test
	public void testFactorialNegative() {
		FactorialCheck fc = new FactorialCheck();
		try {
			fc.factorial(-1);
		} catch (IllegalArgumentException e) {
			assertEquals("Negative numbers are not allowed", e.getMessage());
		}
	}
	
}
