package org.samplejunit;


public class Calculator {
    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b) throws IllegalAccessException {
        if(b == 0){
            throw new IllegalAccessException("cannot divide by zero");
        }
        return a / b;
    }
}
