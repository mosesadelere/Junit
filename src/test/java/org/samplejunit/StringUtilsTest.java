package org.samplejunit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.samplejunit.StringUtils.*;

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

    @Test
    void testConvertToDoubleOK(){
        String age = "2022";
        Double expAge = Double.valueOf(age);
        Double actual = convertToDouble(age);

        assertAll("Do many assertions.", () -> {
            assertNotNull(actual);
            assertEquals(expAge, actual);
        });

        // sample lambda
        assertAll("Do many assertions.Java 8 Lambda style", () -> {
            assertNotNull(actual, () -> "This actual is Null.");
            assertEquals(expAge, actual, () -> "The expected is: " + expAge + " while the actual is: " + actual);
        });
    }

    @Test
    void testConvertToDoubleWithNullArgument(){
        String age = null;
        Double actual = StringUtils.convertToDouble(age);
        assertNull(actual, "The actual is not null");

        assertNull(actual, () -> "The actual is not Null, Java 8 style.");
    }

    @Test
    void testConvertToDoubleThrowException(){
        String age = "N/A";
        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });
    }

    @Test
    void testIsNullOrBlankOK(){
        String input = null;

        assertTrue(StringUtils.isNullorBlank(input), () -> "This string is not null or blank");

        input = " ";
        assertTrue(StringUtils.isNullorBlank(input));

        input = "abc";
        assertFalse(StringUtils.isNullorBlank(input));
    }

    @Test
    void testGetDefaultIfNull(){
        String str = null;
        String defaultStr = "abc";

        String actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertSame(defaultStr, actual, () -> "Expected output is not same with actual");

        // test case with input string is not null
        str = "def";
        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertNotSame(defaultStr, actual, () -> "Expected output is same with actual");

        // test case with input string is empty
        str = "";
        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        if (actual.equals(defaultStr)){
            fail(() -> "The actual should be empty");
        }
    }

    @Test
    void testConcatWithRegularInput(){
        String str1 = "Hello";
        String str2 = "Naija";
        String str3 = "!";
        String expect = str1 + str2 +str3;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expect, actual);
    }

    @Test
    void testConcatWithNullInput(){
        String str1 = "Hello";
        String str2 = "Naija";
        String str3 = null;
        String expect = str1 + str2;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expect, actual);
    }

    @Disabled
    @Test
    void testConcatWithAllNullInput(){
        String actual = StringUtils.concat();
        assertNull(actual);
    }


}