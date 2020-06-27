package com.javatraining.corejavatraining.thread.methods;

public class ThreadNamingArgumentExample {

    public static void main(String[] args) {
        // creating two threads
        ThreadNaming t1 = new ThreadNaming("naming1");
        ThreadNaming t2 = new ThreadNaming("naming2");

        // getting the above created threads names.
        System.out.println("Thread 1: " + t1.getName());
        System.out.println("Thread 2: " + t2.getName());

        t1.start();
        t2.start();
    }

    public static class ThreadNaming extends Thread {
        public ThreadNaming(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Thread is running.....");
        }
    }
}
