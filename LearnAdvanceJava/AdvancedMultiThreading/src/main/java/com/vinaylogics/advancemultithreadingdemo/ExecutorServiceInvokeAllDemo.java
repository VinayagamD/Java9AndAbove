package com.vinaylogics.advancemultithreadingdemo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceInvokeAllDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);

        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> "Task1");
        callables.add(() -> "Task2");
        callables.add(() -> "Task3");

       executorService.invokeAll(callables).forEach(f -> {
           try {
               System.out.println(f.get());
           } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
           }
       });

        executorService.shutdown();
    }
}
