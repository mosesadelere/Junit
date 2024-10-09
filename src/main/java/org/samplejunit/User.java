package org.samplejunit;

public class User {

    public void setAge(String ageString) throws IllegalAccessException {
        try{
            Integer.parseInt(ageString);
        }catch (NumberFormatException e){
            throw new IllegalAccessException("Age must be an Integer..");
        }
    }
}
