package com.vinaylogics.designpattern.creational.singleton;

public class SingletonEager {

    public static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager(){}
}
