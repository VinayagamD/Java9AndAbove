package com.vinay.parallelandconcurrency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class SequentialVsParallel {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        /*numbers.parallelStream()
                .map(SequentialVsParallel::transform)
                .forEach(System.out::println);*/
        use(numbers.stream());
    }

    /*
    * imperative style the structure of sequential code is different from the structure of concurrent code
    *
    * using streams the structure of sequential code is identical to  the structure of concurrent code
    *
    * Mutability should not be present in parallelism
    *
    * */
    private static int transform(int number) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number*2;
    }

    public static void use(Stream<Integer> stream){
        stream
                .parallel()
                .map(SequentialVsParallel::transform)
                .forEach(System.out::println);
    }
}
