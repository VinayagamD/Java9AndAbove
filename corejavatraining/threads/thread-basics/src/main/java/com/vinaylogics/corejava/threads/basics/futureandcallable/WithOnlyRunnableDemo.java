package com.vinaylogics.corejava.threads.basics.futureandcallable;

import java.util.Random;

public class WithOnlyRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable[] randomNumberTasks = new MyRunnable[5];

        for (int i = 0; i < 5; i++)
        {
            randomNumberTasks[i] = new MyRunnable();
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++)
            System.out.println(randomNumberTasks[i].get());
    }

    public static class MyRunnable implements Runnable {
        // Shared object to store result
        private Object result = null;

        @Override
        public void run() {
            Random generator = new Random();
            Integer randomNumber = generator.nextInt(5);

            // As run cannot throw any Exception
            try
            {
                Thread.sleep(randomNumber * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // Store the return value in result when done
            result = randomNumber;

            // Wake up threads blocked on the get() method
            synchronized(this)
            {
                notifyAll();
            }
        }

        public synchronized Object get() throws InterruptedException
        {
            while (result == null)
                wait();

            return result;
        }

    }
}
