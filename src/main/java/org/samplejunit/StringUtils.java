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

    public static Double convertToDouble(String str){
        if (str == null){
            return null;
        }
        return Double.valueOf(str);
    }

    public static boolean isNullorBlank(String str){
        return  str == null || str.trim().isEmpty();
    }

    public static String getDefaultIfNull(final String str, final String defaultStr){
        return str == null ? defaultStr : str;
    }

    public static String concat(String... sts){
        String retVal = null;
        if(sts != null && sts.length > 0){
            StringBuilder sb = new StringBuilder();
            for (String st : sts){
                if (st != null){
                    sb.append(st);
                }
            }
            retVal = sb.toString();
        }
        return retVal;
    }
}
