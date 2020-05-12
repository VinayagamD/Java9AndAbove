package com.vinay.java11;

import java.util.ArrayList;
import java.util.List;

public class CollectionNewMethodExample {

    public static void main(String[] args) {
      /*  List<Integer> numbers = new ArrayList<>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };*/
        List<Integer> numbers = List.of(1,2);

        var numbers2 = List.copyOf(numbers);
        System.out.println(numbers2.equals(numbers));
        System.out.println(numbers2 == numbers);
    }
}
