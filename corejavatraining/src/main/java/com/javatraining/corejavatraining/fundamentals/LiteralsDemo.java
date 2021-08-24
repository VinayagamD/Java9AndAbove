package com.javatraining.corejavatraining.fundamentals;

public class LiteralsDemo {

    public static void main(String[] args) {
        // Primitive types
        int a = 1;
        short s = 1;
        byte byt = 1;
        long b = 2L;
        float c = 1.2F;
        double d = 1.2;
        boolean e = true;
        char f = 'f';


        // Non Primitive Types
        String message = "Hello to java code";
        String[] arrays = {"Savitha", "Sumathi", "Usha"};

        System.out.println(a);
        System.out.println(s);
        System.out.println(byt);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        char chr = 98;
        System.out.println(chr);
        System.out.println(message);
        System.out.println(arrays);
        System.out.println("==================");
        for (String array : arrays){
            System.out.println(array);
        }
        System.out.println("==================");

        int hex = 0xFFEE;
        long hexL = 0xFFEEL;
        int octa = 0170;
        int bin = 0b10101010;
        System.out.println(hex);
        System.out.println(octa);
        System.out.println(bin);
        System.out.println(hexL);

    }
}
