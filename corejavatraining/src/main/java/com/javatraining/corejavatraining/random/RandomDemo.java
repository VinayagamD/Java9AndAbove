package com.javatraining.corejavatraining.random;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random random = new Random();
        int randomInt1 = random.nextInt(1000);
        int randomInt2 = random.nextInt(100);

        System.out.println("Random Integers 1 "+ randomInt1);
        System.out.println("Random Integers 2 "+ randomInt2);

        long randomLong1 = random.nextLong();
        long randomLong2 = random.nextLong();
        System.out.println("Random Long 1 "+ randomLong1);
        System.out.println("Random Long 2 "+ randomLong2);
        System.out.println(random.ints(0,1000).findAny().orElse(0));
    }
}
