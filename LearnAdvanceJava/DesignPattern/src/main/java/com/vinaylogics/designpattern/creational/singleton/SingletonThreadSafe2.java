package com.vinaylogics.designpattern.creational.singleton;

public class SingletonThreadSafe2 {

    private static SingletonThreadSafe2 INSTANCE;

    private SingletonThreadSafe2(){}

    public static SingletonThreadSafe2 getInstance(){
        synchronized (SingletonThreadSafe2.class) {
            if (INSTANCE == null) {
                INSTANCE = new SingletonThreadSafe2();
            }
        }
        return INSTANCE;
    }
}
