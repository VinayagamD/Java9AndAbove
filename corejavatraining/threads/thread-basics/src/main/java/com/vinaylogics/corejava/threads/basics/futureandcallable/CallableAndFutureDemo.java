package com.vinaylogics.corejava.threads.basics.futureandcallable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask is a concrete class that
        // implements both Runnable and Future
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++)
        {
            Callable<Integer> callable = new MyCallable();

            // Create the FutureTask with Callable
            randomNumberTasks[i] = new FutureTask(callable);

            // As it implements Runnable, create Thread
            // with FutureTask
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++)
        {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());

            // This method blocks till the result is obtained
            // The get method can throw checked exceptions
            // like when it is interrupted. This is the reason
            // for adding the throws clause to main
        }

    }

    public static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Random generator = new Random();
            int randomNumber = generator.nextInt(5);

            Thread.sleep(randomNumber * 1000);

            return randomNumber;
        }
    }
}
