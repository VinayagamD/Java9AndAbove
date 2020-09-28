package com.javatraining.corejavatraining.fundamentals;

public class LiteralsDemo {

    public static void main(String[] args) {
        // Primitive types
        int a = 1;
        long b = 2L;
        float c = 1.2F;
        double d = 1.2;
        boolean e = true;
        char f = 'f';

        // Non Primitive Types
        String message = "Hello to java code";

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(message);

        int hex = 0xFFEE;
        int octa = 0170;
        int bin = 0b10101010;
        System.out.println(hex);
        System.out.println(octa);
        System.out.println(bin);

    }
}
