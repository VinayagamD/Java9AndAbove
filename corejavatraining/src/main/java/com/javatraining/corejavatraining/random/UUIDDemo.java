package com.javatraining.corejavatraining.random;

import java.util.UUID;

public class UUIDDemo {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString().replace("-", ""));
    }
}
