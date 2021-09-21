package com.vinaylogics.corejavatraining.packages.demo.utils;

import java.util.Collections;

public class StringOpDemo {

    public static void main(String[] args) {
        String data = "DemoStringForOperation";
        String data2 = "DemoStringForOperation";
        String data3 = new String("DemoStringForOperation");
        System.out.println(data == data2);
        System.out.println(data == data3);
        System.out.println(data.equals(data2));
        System.out.println(data.equals(data3));
        System.out.println(data.toLowerCase());
        System.out.println(data.toUpperCase());
        Collections.singletonList(data.toCharArray()).forEach(System.out::println);
        for (Character ch: data.toCharArray()) {
            System.out.println(ch);
        }
        System.out.println(data.substring(2,8));
        System.out.println(data.indexOf('e'));
        System.out.println(data.charAt(10));
        System.out.println(data.contains("For"));
        System.out.println(data.concat("hello"));
        System.out.println(data.codePointBefore(10));
        char[] datas = data.toCharArray();
        for (int i = datas.length-1; i >= 0; i--){
            System.out.print(datas[i]);
        }
        System.out.println();
        System.out.println(data);
        StringBuffer stringBuffer = new StringBuffer(data);
        System.out.println(stringBuffer.reverse());
        stringBuffer.reverse();
        stringBuffer.append("fjakfjalkj").append("fjshjfkh").append("\t")
                .append("fjhskjfkj").append("\n").append("fgshkhfkjhakj");
        System.out.println(stringBuffer.toString());
//        System.out.println(String.valueOf(null));
    }
}
