package com.vinaylogics.advancemultithreadingdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExecuteDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> System.out.println("ExecutorsService"));
        executorService.shutdown();
    }
}
