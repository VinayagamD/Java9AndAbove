package com.vinaylogics.corejavatraining.oops.basics.objects;

import com.vinaylogics.corejavatraining.oops.basics.classes.Test;

public class TestObject {

    public static void main(String[] args) {
        Test test = new Test();
        test.setFirstName("TestFName");
        test.setLastName("TestLName");
        System.out.println(test.getFirstName());
        System.out.println(test.getLastName());
        System.out.println(test);
        System.out.println(test.hashCode());
        System.out.println(Integer.toHexString(test.hashCode()));
        System.out.println(test.getClass().getName());
        test.action();
    }
}
