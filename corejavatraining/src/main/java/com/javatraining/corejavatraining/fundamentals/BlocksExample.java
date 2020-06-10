package com.javatraining.corejavatraining.fundamentals;

public class BlocksExample {

    {
        System.out.println("Instance Block Called");
    }

    static {
        System.out.println("Static Block Called");
    }

    public static void main(String[] args) {
        System.out.println("Main Block Called");
        {
            System.out.println("Inner Method Block is called");
        }

        BlocksExample blocksExample = new BlocksExample();
    }
}
