package com.vinaylogics.corejavatraining.packages.demo.utils;

import java.util.Arrays;
import static java.lang.System.*;

public class StringDemo {

    public static void main(String[] args) {

        String data = "Manjunath attending core java training";
        String data2 = " Manjunath attending core java training ";
        Arrays.asList(data.split(" ")).forEach(System.out::println);
        System.out.println(data.toCharArray());
        char [] dataArray = data.toCharArray();
        for (int i = dataArray.length-1; i >=0 ; i--) {
            System.out.print(dataArray[i]);
        }
        out.println();
        out.println(data.charAt(3));
        out.println(data.substring(4, 10));
        out.println(data2);
        out.println(data2.trim());
        System.out.println(data2.replace(" ", "-"));
        System.out.println(data.replace("a", "e"));
        System.out.println(data.toUpperCase());
        System.out.println(data.toLowerCase());
        System.out.println(data.length());
        System.out.println(data.indexOf('j'));
    }
}
