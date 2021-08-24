package com.vinaylogics.advancemultithreadingdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{
            System.out.println("Executor Service");
        });
        executorService.shutdown();
    }
}
