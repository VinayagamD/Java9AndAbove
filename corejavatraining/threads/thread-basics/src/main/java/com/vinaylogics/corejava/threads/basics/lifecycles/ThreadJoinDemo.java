package com.vinaylogics.corejava.threads.basics.lifecycles;

public class ThreadJoinDemo implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new ThreadJoinDemo());
        t.start();

        // Waits for 1000ms this thread to die.
        t.join(1000);

        System.out.println("\nJoining after 1000"+ " mili seconds: \n");
        System.out.println("Current thread: " + t.getName());


        // Checks if this thread is alive
        System.out.println("Is alive? " + t.isAlive());
    }

    @Override
    public void run() {

        Thread t = Thread.currentThread();
        System.out.println("Current thread: "+ t.getName());

        // checks if current thread is alive
        System.out.println("Is Alive? " + t.isAlive());
    }
}
