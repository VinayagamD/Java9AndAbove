package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<String> data = new LinkedList<>();
        data.add("One");
        data.add("Two");
        data.add("Three");
        System.out.println(data);
        System.out.println(data.remove());
        System.out.println(data);
    }
}
