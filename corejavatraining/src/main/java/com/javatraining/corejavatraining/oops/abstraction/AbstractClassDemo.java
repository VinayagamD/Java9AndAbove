package com.javatraining.corejavatraining.oops.abstraction;

import java.io.Serializable;

public class AbstractClassDemo {

    public static abstract class MyAbstractClass2 {
        // 0 to 100 %
        public void testMethod1(){

        }

        public void testMethod2(){

        }

    }

    public static abstract class MyAbstractClass {

        public abstract void abstractMethodCall();

        public void concreteMethodCall(){
            System.out.println("This is concrete call");
        }
    }

    public static void main(String[] args) {
        MyAbstractClass myAbstractClass = new MyAbstractClass() {
            @Override
            public void abstractMethodCall() {
                System.out.println("Object created abstract method call");
            }
        };
        MyInterface myInterface = new MyInterface() {
            @Override
            public void callMethod() {

            }
        };

        // java 8
        MyInterface myInterface1 = () -> {};

        MyAbstractClass myAbstractClass2 = new SubAbstractClass();


    }

    public static class SubAbstractClass extends MyAbstractClass implements MyInterface, Serializable {

        @Override
        public void abstractMethodCall() {
            System.out.println("Object created abstract method call");
        }

        @Override
        public void callMethod() {
            System.out.println("Object created interface method call");
        }
    }

    @FunctionalInterface
    public  interface MyInterface {
         void callMethod();

        // Java 8 onwards
       /* default void internalCall(){
        }

        static void classCall(){

        }*/
    }


    public interface MyInterface2{
        // 100 % abstraction - Java 7
        void concreteMethod();
        void method2();
    }
}
