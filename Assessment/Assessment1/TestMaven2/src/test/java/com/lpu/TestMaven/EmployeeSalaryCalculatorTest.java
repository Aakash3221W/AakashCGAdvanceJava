package com.lpu.TestMaven;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSalaryCalculatorTest {

    // --- POSITIVE PARAMETERIZED TESTS ---

    @ParameterizedTest
    @CsvSource({
        "20000.0, 5000.0, 10.0, 4000.0, 2000.0, 31000.0, 27900.0", // Example Case 
        "10000.0, 2000.0, 5.0,  2000.0, 1000.0, 15000.0, 14250.0",
        "50000.0, 0.0,    20.0, 10000.0, 5000.0, 65000.0, 52000.0"
    })
    @DisplayName("Verify HRA, DA, Gross, and Net calculations for valid inputs")
    void testAllSalaryCalculations(double basic, double bonus, double tax, 
                                   double h, double d, double g, double n) {
        EmployeeSalaryCalculator calculator = new EmployeeSalaryCalculator(basic, bonus, tax);
        
        assertEquals(h, calculator.calculateHRA(), "HRA calculation failed");
        assertEquals(d, calculator.calculateDA(), "DA calculation failed");
        assertEquals(g, calculator.calculateGrossSalary(), "Gross Salary calculation failed");
        assertEquals(n, calculator.calculateNetSalary(), "Net Salary calculation failed");
    }

    // --- NEGATIVE PARAMETERIZED TESTS (EXCEPTIONS) ---

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -100.0, -5000.0})
    @DisplayName("Throw exception for invalid Basic Salary values")
    void testInvalidBasicSalary(double basic) {
        EmployeeSalaryCalculator calculator = new EmployeeSalaryCalculator(basic, 5000, 10);
        
        assertThrows(IllegalArgumentException.class, () -> calculator.validateSalary(),
            "Expected exception for basic salary: " + basic);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, 101.0, 150.0})
    @DisplayName("Throw exception for invalid Tax Percentage values")
    void testInvalidTaxPercent(double tax) {
        EmployeeSalaryCalculator calculator = new EmployeeSalaryCalculator(20000, 5000, tax);
        
        assertThrows(IllegalArgumentException.class, () -> calculator.validateSalary(),
            "Expected exception for tax percentage: " + tax);
    }
}