package com.vinaylogics.designpattern.creational.singleton;

public class SingletonThreadSafe1 {

    private static SingletonThreadSafe1 INSTANCE;

    private SingletonThreadSafe1(){}

    public static synchronized SingletonThreadSafe1 getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SingletonThreadSafe1();
        }
        return INSTANCE;
    }
}
