package com.javatraining.corejavatraining.abtsraction;

import com.javatraining.corejavatraining.fundamentals.DataTypeExample;

public class AbstractionClassDemo {

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void sayHi() {

            }

            @Override
            void methodM2() {

            }

            @Override
            public void run() {

            }
        };

        AbstractClass2 abstractClass2 = new AbstractClass2(){};

        MyAbstractClass myAbstractClass = new MyAbstractClass();
    }

    public static abstract class AbstractClass implements Runnable, DataTypeExample.ExampleInterface {

        void methodM1(){

        }

        abstract void methodM2();
    }



    public static abstract class AbstractClass2{
        void methodM1(){

        }

        void methodM2(){

        }

    }

    public static class MyAbstractClass extends AbstractClass{

        @Override
        void methodM2() {

        }

        @Override
        public void run() {

        }

        @Override
        public void sayHi() {

        }
    }
}
