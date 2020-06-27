package com.javatraining.corejavatraining.thread.creations;

public class ThreadsExtendsThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            System.out.println("Inside RunMethod Of My Thread");
        }
    }
}
