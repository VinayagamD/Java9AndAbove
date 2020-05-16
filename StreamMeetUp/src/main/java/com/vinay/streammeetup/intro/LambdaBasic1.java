package com.vinay.streammeetup.intro;

public class LambdaBasic1 {

    public static void main(String[] args) {
        int data = 10;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Legacy Runnable " + data);
            }
        };

        System.out.println("-------------------------- Imperative Style ----------------------------");
        Thread thread = new Thread(runnable,"Imperative");
        thread.start();
        System.out.println("----------------------------- Functional Style ---------------------------");
        Runnable runnable1 = () -> System.out.println("Functional Runnable "+ data);
        thread = new Thread(runnable1,"functional");
        thread.start();
    }
}
