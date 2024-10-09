package org.samplejunit;

public class StringUtils {
    public String reverse(String input) throws IllegalAccessException {
        if(input == null){
            throw new IllegalAccessException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    public  boolean isPalindrome(String input) throws IllegalAccessException {
        if(input == null){
            throw new IllegalAccessException("Input cannot be null");
        }
        String reversed = reverse(input);
        return input.equals(reversed);
    }
}
