package com.javatraining.corejavatraining.polymorphism;

public class AvoidOverriding {

    public static void main(String[] args) {

    }

    public static class MyNormalClass{
        public void normalMethod(){

        }

        public final void finalMethod(){

        }
    }

    public static final class MyFinalClass {

    }

    public static class MySubclass extends MyNormalClass{
        @Override
        public void normalMethod() {
            super.normalMethod();
        }


    }

    /*
     // Final class cannot be extended
    public static class MyFinalSubClass extends MyFinalClass{

    }
    */
}
