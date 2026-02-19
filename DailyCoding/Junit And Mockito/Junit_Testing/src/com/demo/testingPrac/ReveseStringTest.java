package com.demo.testingPrac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ReveseStringTest {
	@Test
	public void testReverse() {
		ReveseString rev = new ReveseString();
		assertEquals("olleh", rev.reverse("hello"));
	}
	
	@Test
	public void testReverseWithEquals() {
		ReveseString rev = new ReveseString();
		String result = rev.reverse("world");
		assertTrue(result.equals("dlrow"));
	}
	
	
	
	@Test
	public void testPalindrome() {
		ReveseString rev = new ReveseString();
		assertEquals("Palindrome", rev.plaindrome("madam"));
		assertEquals("Not a Palindrome", rev.plaindrome("hello"));
	}
	
	
	
}
