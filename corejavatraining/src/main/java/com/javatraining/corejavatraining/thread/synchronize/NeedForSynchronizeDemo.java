package com.javatraining.corejavatraining.thread.synchronize;

public class NeedForSynchronizeDemo {

    public static void main(String[] args) {
        MultiThread t = new MultiThread();
        t.increment();
        System.out.println(t.getValue());
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
