package com.javatraining.corejavatraining.collections.coreInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
        System.out.println(datas.remove("Five"));
        System.out.println(datas.remove("Five"));
        System.out.println(datas.indexOf("Five"));
        datas = datas.subList(1,2);
        System.out.println(datas);
        Collections.sort(datas, Collections.reverseOrder());
        System.out.println(datas);
        Collections.reverse(datas);
        System.out.println(datas);

    }
}
