package com.javatraining.corejavatraining.thread;

public class ThreadSleepDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread Running");
                try {
//                    sleep(5000);
//                    wait();
                } catch (IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
                System.out.println("After Sleep");
            }
        };

        thread.start();
//        thread.yield();
        System.out.println("Main Code Running");

    }

}
