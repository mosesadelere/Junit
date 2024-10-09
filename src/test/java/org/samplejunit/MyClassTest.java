package org.samplejunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyClassTest {
    MyClass myClass;
    @BeforeEach
    void setup(){
        myClass = new MyClass();
    }

    @Test
    void testExceptionIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> myClass.multiply(1000, 5));
    }

    @Test
    void testMultiply(){
        Assertions.assertEquals(50, myClass.multiply(10, 5), "10 by 5 must be 50");
    }
}
