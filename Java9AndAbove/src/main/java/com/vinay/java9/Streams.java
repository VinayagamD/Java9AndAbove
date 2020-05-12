package com.vinay.java9;

import java.util.Arrays;
import java.util.List;

public class Streams {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
          11, 12, 13, 14, 51, 16, 17, 81, 91
        );
        numbers.stream()
//                .filter(e -> e< 50)
//                .limit(3)
//                .skip(7)
//                .takeWhile(e -> e < 50)
                .dropWhile(e -> e < 50)
                .forEach(System.out::println);
    }

    /*
     *filter takes a predicate. It is like a gate that opens or closes per element
     * limit takes an int. It is like a door that is open, but may close forever
     * skip takes an int. It is like a door that is closed, but may open forever
     *
     * imperative style - break - functional style - takeWhile
     */

    /*
    * Haskel                    Java
    * take(number)              limit(int)
    * drop(number)              skip(int)
    * takeWhile(Predicate)      takeWhile(Predicate)
    * dropWhile(Predicate)      dropWhile(Predicate)
     */
}


