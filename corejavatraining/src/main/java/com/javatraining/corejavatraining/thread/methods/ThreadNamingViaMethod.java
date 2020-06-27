package com.javatraining.corejavatraining.thread.methods;

public class ThreadNamingViaMethod {

    public static void main(String[] args) {
        // creating two threads
        ThreadNaming t1 = new ThreadNaming();
        ThreadNaming t2 = new ThreadNaming();

        // getting the above created threads names.
        System.out.println("Thread 1: " + t1.getName());
        System.out.println("Thread 2: " + t2.getName());

        t1.start();
        t2.start();

        // Now changing the name of threads.
        t1.setName("naming1");
        t2.setName("naming2");

        // again getting the new names
        // of the threads.
        System.out.println("Thread names after changing the thread names");
        System.out.println("New Thread 1 name: " + t1.getName());
        System.out.println("New Thread 2 name: " + t2.getName());
    }

    public static class ThreadNaming extends Thread {
        @Override
        public void run() {
            System.out.println("Thread is running....");
        }
    }
}
