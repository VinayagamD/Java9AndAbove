package com.javatraining.corejavatraining.strings;

public class SCPDemo {

    public static void main(String[] args) {
        String s1 = "Data";
        String s2 = "Data";
        String s3 = new String("Data");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
