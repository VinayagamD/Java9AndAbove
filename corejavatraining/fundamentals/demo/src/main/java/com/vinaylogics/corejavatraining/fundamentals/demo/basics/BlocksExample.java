package com.vinaylogics.corejavatraining.fundamentals.demo.basics;

public class BlocksExample {

    {
        System.out.println("Instance Block Called");
    }

    {
        System.out.println("Instance Block Called2");
    }

    static {
        System.out.println("Static Block Called");
    }

    static {
        System.out.println("Static Block Called2");
    }

    public static void main(String[] args) {
        System.out.println("Main Block Called");
        {
            System.out.println("Inner Method Block is called");
        }

        BlocksExample blocksExample = new BlocksExample();
        test1();
        blocksExample.test2();
    }

    public static void test1(){

        {
            System.out.println("Another inner block within test1");
        }
    }

    public void test2(){
        {
            System.out.println("Another inner block within test2");
        }
    }
}
