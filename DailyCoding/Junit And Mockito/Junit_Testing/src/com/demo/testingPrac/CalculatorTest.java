package com.demo.testingPrac;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Spy
    Calculator calc;

    @Test
    void testAddWithSpy() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSubWithSpy() {
        doReturn(1).when(calc).sub(5, 4);
        assertEquals(1, calc.sub(5, 4));
    }
}
