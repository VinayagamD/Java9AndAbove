package com.vinaylogics.corejava.threads.basics.creations;

import java.util.stream.IntStream;

public class ThreadRunDirect {

    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach( i ->{
            MyThread myThread = new MyThread();
            // start() is replaced with run() for
            // seeing the purpose of start
//            myThread.run();
            myThread.start();
        });
    }


    public static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("Thread name " + Thread.currentThread().getName());
                // Displaying the thread that is running
                System.out.println("Thread " + Thread.currentThread().getId() + " is running");

            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }
    }

}
