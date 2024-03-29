package com.vinaylogics.corejava.threads.basics.methods;

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
        // t1.setDaemon(true);
        // t1.setDaemon(false);

        t2.start();
    }
}
