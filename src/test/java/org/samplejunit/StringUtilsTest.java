package org.samplejunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private final StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() throws IllegalAccessException {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("54321", stringUtils.reverse("12345"));
    }

    @Test
    void testReverseWithNull() {
        assertThrows(IllegalAccessError.class, () -> stringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() throws IllegalAccessException {
        assertTrue(stringUtils.isPalindrome("madam"));
    }

    @Test
    void testIsPalindromeWithNull(){
        assertThrows(IllegalAccessError.class, () -> stringUtils.isPalindrome(null));
    }
}