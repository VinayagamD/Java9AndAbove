package com.javatraining.corejavatraining.thread.methods;

public class DaemonThreadDemo extends Thread{

    public DaemonThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {

        // Checking whether the thread is Daemon or not
        if(Thread.currentThread().isDaemon())
        {
            System.out.println(getName() + " is Daemon thread");
        }

        else
        {
            System.out.println(getName() + " is User thread");
        }
    }

    public static void main(String[] args) {
        DaemonThreadDemo t1 = new DaemonThreadDemo("t1");
        DaemonThreadDemo t2 = new DaemonThreadDemo("t2");
        DaemonThreadDemo t3 = new DaemonThreadDemo("t3");

        // Setting user thread t1 to Daemon
        t1.setDaemon(true);

        // starting first 2 threads
        t1.start();
        t2.start();

        // Setting user thread t3 to Daemon
        t3.setDaemon(true);
        t3.start();
    }
}
