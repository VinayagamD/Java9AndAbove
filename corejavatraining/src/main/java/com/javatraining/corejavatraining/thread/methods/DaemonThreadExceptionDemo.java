package com.javatraining.corejavatraining.thread.methods;

public class DaemonThreadExceptionDemo extends Thread{

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("Check if its DaemonThread: " + Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
        DaemonThreadExceptionDemo t1 = new DaemonThreadExceptionDemo();
        DaemonThreadExceptionDemo t2 = new DaemonThreadExceptionDemo();
        t1.start();

        // Exception as the thread is already started
        t1.setDaemon(true);

        t2.start();
    }
}
