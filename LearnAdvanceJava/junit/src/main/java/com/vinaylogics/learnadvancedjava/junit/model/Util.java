package com.vinaylogics.learnadvancedjava.junit.model;

public class Util {

    public String toUpper(String data){
        if(data==null)
            throw new NullPointerException("Null Data not accepted");

        return data.toUpperCase();
    }
}
