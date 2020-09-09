package com.vinaylogics.advancemultithreadingdemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSubmitDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(()->{
            System.out.println("ExecutorsService");
            System.out.println("Runnable");
        });
        System.out.println(future.isDone());

       Future<String> future1  = executorService.submit(()->{
            System.out.println("ExecutorsService");
            System.out.println("Callable");
            return "Callable Data";
        });

        System.out.println(future1.get());
        executorService.shutdown();
    }
}
