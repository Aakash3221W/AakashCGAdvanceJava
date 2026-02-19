package com.demo.testingPrac;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class AgeValidaterTest {
	@Mock
	Database database;
	@InjectMocks
	AgeValidater ageValidater;
	
	@Test
	void testValidAge() {
		assertDoesNotThrow(() -> ageValidater.vaidateAge(25));
	}
	
	@Test
	void testInvalidAge() {
		assertThrows(InvalidAgeException.class, () -> ageValidater.vaidateAge(-5));
	}
}
