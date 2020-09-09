package com.vinaylogics.advancemultithreadingdemo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceInvokeAnyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);

        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> "Task1");
        callables.add(() -> "Task2");
        callables.add(() -> "Task3");

        String result = executorService.invokeAny(callables);
        System.out.println("Result = "+result);

        executorService.shutdown();
    }
}
