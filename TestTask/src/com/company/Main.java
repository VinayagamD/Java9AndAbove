package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Input int inputArr[] = { 9, 8, 7, 4, 5, 3, 1, 6 };
        // Sum = 11
        // 11 - 9= 3
        int inputArr[] = { 9, 8, 7, 4, 5, 3, 1, 6 };
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inputArr.length-1; i++) {
            for(int j =i+1; j < inputArr.length;j++){
                if(inputArr[i]+inputArr[j] == 11){
                    map.put(inputArr[i], inputArr[j]);
                }
            }
        }
        System.out.println(map);
        List<Integer> intList = new ArrayList<>();
        for (int data:inputArr) {
            intList.add(data);
        }


    }
}
