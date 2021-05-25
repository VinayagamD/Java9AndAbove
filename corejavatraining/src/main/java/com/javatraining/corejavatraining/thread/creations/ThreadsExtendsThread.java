package com.javatraining.corejavatraining.thread.creations;

public class ThreadsExtendsThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(Thread.currentThread().getName());
        myThread.start();
//        myThread.run();
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            System.out.println("Inside RunMethod Of My Thread");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
