package com.vinaylogics.corejava.threads.basics.synchronize;

public class NeedForSynchronizeDemo {

    public static void main(String[] args) {
        MultiThread t = new MultiThread();
        MultiThread t1 = new MultiThread();
        for (int i = 0; i < 1000; i++) {
            t.increment();
            t1.increment();
            System.out.println(t.getValue());
            System.out.println(t.getValue());
        }


    }

    public static class  MultiThread {
        private int i = 0;

        public void increment(){
            i++;
        }

        public int getValue(){
            return i;
        }
    }
}
