package com.vinaylogics.designpattern.creational.singleton;

public class SingletonThreadSafe3 {
    private static final Object LOCK = new Object();
    private static SingletonThreadSafe3 INSTANCE;

    private SingletonThreadSafe3(){}

    public static SingletonThreadSafe3 getInstance(){
        if(INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonThreadSafe3();
                }
            }
        }
        return INSTANCE;
    }
}
