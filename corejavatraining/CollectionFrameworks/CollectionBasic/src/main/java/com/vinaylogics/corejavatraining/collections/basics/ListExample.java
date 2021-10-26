package com.vinaylogics.corejavatraining.collections.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> datas = new ArrayList<>();
//       {"One", "Two", "Three");
        datas.add("One");
        datas.add("One");
        datas.add("One");
        datas.add("One");
        datas.add("One");
        datas.add("Two");
        datas.add("Three");
        datas.add("Six");
        datas.add("Ten");
        datas.add("Four");
        datas.add("Four");
        datas.add("Four");
        datas.add("Four");
        datas.add("Four");
        datas.add("Four");
        datas.add("Five");
        System.out.println(datas);
        System.out.println(datas.get(1));
        System.out.println(datas.indexOf("Five"));
        System.out.println(datas.indexOf("Four"));
        System.out.println(datas.remove("Five"));
        System.out.println(datas.remove("Five"));
        System.out.println(datas.indexOf("Five"));
//        Collections.sort(datas, Collections.reverseOrder());
//        System.out.println(datas);
        Collections.reverse(datas);
        System.out.println(datas);
        datas = datas.subList(1, 5);
        System.out.println(datas);

    }
}
