package org.samplejunit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static User user;

    @BeforeAll
    public static void setup(){
        user = new User();
    }

    @Test
    void exceptionTesting(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                user.setAge("A"));
        assertEquals("Age must be an Integer.", exception.getMessage());
    }
}