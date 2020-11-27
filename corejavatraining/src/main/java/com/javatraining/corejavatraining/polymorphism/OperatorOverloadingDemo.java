package com.javatraining.corejavatraining.polymorphism;

public class OperatorOverloadingDemo {

    public static void main(String[] args) {
        OperatorOverload op = new OperatorOverload(10);
        op.operator(11);
        op.operator(String.valueOf(11));
    }

    public static class OperatorOverload {
        int a;

        public OperatorOverload(int a) {
            this.a = a;
        }

        void operator(int b){
            this.a += b;
            System.out.println(a);
        }

        void operator(String b){
            System.out.println(a+b);
        }
    }
}
