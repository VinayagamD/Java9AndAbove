package com.javatraining.corejavatraining.thread.threadlifecycle;

public class ThreadInterruptDemo extends Thread{

    public static void main(String[] args) {
        ThreadInterruptDemo tid1 = new ThreadInterruptDemo();
        tid1.start();
        tid1.interrupt();
        System.out.println(tid1.isInterrupted());
        System.out.println(tid1.isAlive());
    }
}
