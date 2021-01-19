package com.javatraining.corejavatraining.oops_basics.abstraction.test;

import com.javatraining.corejavatraining.oops_basics.abstraction.MyAbstract;
import com.javatraining.corejavatraining.oops_basics.abstraction.MyImplement;
import com.javatraining.corejavatraining.oops_basics.abstraction.MyInterface;

public class TestAbstract {
    static MyAbstract myAbstract;
    static MyInterface myInterface;

    public static void main(String[] args) {
        myAbstract = new MyAbstract() {
            @Override
            public void testMethod2() {
                System.out.println("Test Method2");
            }

            @Override
            public void testMethod3() {
                System.out.println("Test Method3");
            }
        };

        myAbstract = new MyImplement();

        myInterface = new MyInterface() {
            @Override
            public void test() {
                System.out.println("Test");
            }
        };

        myInterface = () -> System.out.println("Test");
    }
}
