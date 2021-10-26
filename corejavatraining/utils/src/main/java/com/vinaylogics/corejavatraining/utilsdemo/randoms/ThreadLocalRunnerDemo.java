package com.vinaylogics.corejavatraining.utilsdemo.randoms;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRunnerDemo {

    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom
                .current()
                .ints(1, 10000)
                .findAny()
                .orElse(1));
        System.out.println(ThreadLocalRandom.current().nextInt());
        System.out.println(ThreadLocalRandom.current().nextInt(1000));
        System.out.println("Mobile OTP = "+ ThreadLocalRandom.current().nextInt(1000,9999));
        System.out.println("Mobile OTP = "+ ThreadLocalRandom.current().nextInt(100000,999999));
    }
}
