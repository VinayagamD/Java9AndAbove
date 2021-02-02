package com.javatraining.corejavatraining.enum_example;

import java.util.Arrays;

public enum  Bike {

    MOTOR_CYCLE,
    MOUNTAIN,
    BULLET;

    public static void main(String[] args) {
        Arrays.asList(Bike.values()).forEach(System.out::println);
        System.out.println(Bike.valueOf("MOTOR_CYCLE"));
        System.out.println(Bike.MOTOR_CYCLE.ordinal());
        System.out.println(Bike.MOUNTAIN.ordinal());
    }
}
