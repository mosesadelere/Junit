package org.samplejunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void add() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void subtract() {
        assertEquals(1, calculator.subtract(5, 4));
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void multiply() {
        assertEquals(6, calculator.multiply(2, 3),
                "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero(){
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));
        assertEquals(0, calculator.multiply(5, 0),
                "Multiply with zero should be zero");
        assertEquals(0, calculator.multiply(0, 5),
                "Multiply with zero should be zero");
    }

    @Test
    void divide() throws IllegalAccessException {
        try {
            assertEquals(2, calculator.divide(4, 2));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}