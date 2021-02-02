package com.javatraining.corejavatraining.abtsraction.interface_types;

public interface NormalInterface extends EgInterface{
    int A = 20;
    int B = 20;

    void test();

    private void testSubMethod(){

    }

    default void testB(){

    }

    static void staticMethod(){

    }
}
