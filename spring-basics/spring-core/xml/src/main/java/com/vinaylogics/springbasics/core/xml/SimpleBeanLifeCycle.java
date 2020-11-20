package com.vinaylogics.springbasics.core.xml;

public class SimpleBeanLifeCycle implements LifeCycleBean {

    @Override
    public void init() {
        System.out.println("Bean Initialized");
    }

    @Override
    public void destroy() {
        System.out.println("Bean Destroyed");
    }




}
