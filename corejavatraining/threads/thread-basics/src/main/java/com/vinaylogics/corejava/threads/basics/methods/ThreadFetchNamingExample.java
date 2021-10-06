package com.vinaylogics.corejava.threads.basics.methods;

public class ThreadFetchNamingExample {

    public static class ThreadNaming extends Thread {
        @Override
        public void run() {
            // getting the current thread 's name.
            System.out.println("Fetching current thread name..");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // creating two threads
        ThreadNaming t1 = new ThreadNaming();
        ThreadNaming t2 = new ThreadNaming();
        System.out.println(Thread.currentThread().getName());
        t1.start();
        t2.start();
    }
}
