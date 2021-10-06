package com.vinaylogics.corejava.threads.basics.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class NeedForSynchronizeWithOutLockThreadDemo {

    public static void main(String[] args) {
        MultiThread t = new MultiThread();
        List<MultiThreadRunner> multiThreadRunners = new ArrayList<>();
        IntStream.rangeClosed(1, 10).forEach(i -> {
            multiThreadRunners.add(new MultiThreadRunner(t));
        });

        multiThreadRunners.forEach(Thread::start);

    }

    public static class  MultiThread {
        private final AtomicInteger i = new AtomicInteger(0);

        public  void increment(){
            i.incrementAndGet();
        }

        public  int getValue(){
            return i.get();
        }
    }

    public static class MultiThreadRunner extends Thread {
        private final MultiThread multiThread;

        public MultiThreadRunner(MultiThread multiThread) {
            this.multiThread = multiThread;
        }

        @Override
        public void run() {
            multiThread.increment();
            System.out.println(multiThread.getValue());
        }
    }
}
