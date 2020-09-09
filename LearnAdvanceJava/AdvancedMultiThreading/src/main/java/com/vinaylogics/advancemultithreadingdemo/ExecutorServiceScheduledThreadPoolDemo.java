package com.vinaylogics.advancemultithreadingdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.execute(()->{
            System.out.println("Executor Service");
        });
        executorService.shutdown();
    }
}
