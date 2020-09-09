package com.vinaylogics.advancemultithreadingdemo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceFixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{
            System.out.println("Executor Service");
        });
        executorService.shutdown();
    }
}
