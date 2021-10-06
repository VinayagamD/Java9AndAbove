package com.vinaylogics.corejava.threads.basics.creations;

public class ThreadWithThread {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

        // Runnable Creation Normal Way
        Runnable runnableLegacy = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Anonymous");
            }
        };

        // Runnable Creation By Lambda
        Runnable runnable = () ->{
            System.out.println("Runnable Lambda");
        };

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Anonymous");
            }
        });
        thread.start();
        thread = new Thread(() ->{
            System.out.println("Runnable Lambda");
        });

        thread.start();
    }
}
