package com.vinaylogics.corejava.threads.basics.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NeedForSynchronizeWithLockThreadDemo {

    public static void main(String[] args) {
        MultiThread t = new MultiThread();
        List<MultiThreadRunner> multiThreadRunners = new ArrayList<>();
        IntStream.rangeClosed(1, 100).forEach(i -> {
            multiThreadRunners.add(new MultiThreadRunner(t));
        });

        multiThreadRunners.forEach(Thread::start);

    }

    public static class  MultiThread {
        private int i = 0;

        public  void increment(){
            i++;
        }

        public  int getValue(){
            return i;
        }
    }

    public static class MultiThreadRunner extends Thread {
        private final MultiThread multiThread;

        public MultiThreadRunner(MultiThread multiThread) {
            this.multiThread = multiThread;
        }

        @Override
        public void run() {
            synchronized (multiThread) {
                multiThread.increment();
                System.out.println(multiThread.getValue());
            }
        }
    }
}
