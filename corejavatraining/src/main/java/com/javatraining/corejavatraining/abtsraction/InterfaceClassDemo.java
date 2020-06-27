package com.javatraining.corejavatraining.abtsraction;

public class InterfaceClassDemo {

    public static void main(String[] args) {
        FunctionDemoInterface functionDemoInterface = ()->{

        };

        FunctionDemoInterface2 functionDemoInterface2 = (d, p) ->{
            System.out.println("Data " +d +", p " +p);
        };

        functionDemoInterface2.demoFunctional("test",3);

        MyInnerClass myInnerClass = new MyInnerClass();
        myInnerClass.testCallback(new MyInterface() {
            @Override
            public void testM1() {
                System.out.println("Interface Callback");
            }
        });

        // ()->{}

        myInnerClass.testCallback(()->{
            System.out.println("Interface Callback");
        });
    }


    public interface MyInterface {
        void testM1();
    }

    public interface MyInterface2 extends MyInterface{

    }

    public static class MyInnerClass implements MyInterface2{

        @Override
        public void testM1() {

        }

        public void testCallback(MyInterface myInterface){
            myInterface.testM1();
        }
    }

    public interface MyInnerInterface {}

    @FunctionalInterface
    public interface FunctionDemoInterface {
        void demoFunctional();
    }

    @FunctionalInterface
    public interface FunctionDemoInterface2 {
        void demoFunctional(String data, int position);
    }
}