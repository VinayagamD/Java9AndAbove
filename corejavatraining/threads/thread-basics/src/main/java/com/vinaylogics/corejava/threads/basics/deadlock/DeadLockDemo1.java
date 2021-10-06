package com.vinaylogics.corejava.threads.basics.deadlock;

public class DeadLockDemo1 {

    public static final Object r1 = new Object();
    public static final Object r2 = new Object();

    public static void main(String[] args) {
        System.out.println("Main Thread");
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        System.out.println("T1 Started");
        t1.start();
        System.out.println("T2 Started");
        t2.start();
    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (r1){
                System.out.println("R1 Locked by t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("R2 Locked by t1");
                }
            }
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (r2){
                System.out.println("R2 Locked by t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("R1 Locked by t2");
                }
            }
        }
    }
}
