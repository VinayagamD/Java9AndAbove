package com.javatraining.corejavatraining.thread.creations;

public class TheadImplementsRunnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Inside My Runnable run");
        }
    }
}
