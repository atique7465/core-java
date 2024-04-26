package org.atique.java.functionalprogramming;

import java.util.stream.Stream;

/**
 * @author atiQue
 * @since 26'Apr 2024 at 10:15 PM
 */

public class StreamOperations {
    public static void main(String[] args) {

        //limit operation
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        stream = stream.limit(5); //let the elements go to the next stream till count is 5
        stream.forEach(System.out::println);

        /*
        we can write the same code as
        Writing code this way is called "fluent api"***
         */
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .limit(5)
                .forEach(System.out::println);

        //Filter operation
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(e -> e % 2 == 0) //it takes a predicate
                .forEach(System.out::println);

        //Map operation
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .limit(5)
                .map(e -> e * 2) //takes a Function, general recommendation is not to use any io/side effect, just transform and return
                .forEach(System.out::println);

        //Peak and Debugging
        Stream.of("Apple", "Watermelon", "Banana", "Orange", "Strawberry")
                .filter(e -> e.length() <= 6)
                .peek(e -> System.out.println("Filter passed: " + e)) //it takes a consumer
                .map(String::toUpperCase)
                .peek(e -> System.out.println("To Upper: " + e))
                .forEach(e -> System.out.println("Final Result: " + e));

        /*
        Distinct & Sorted operation
        Distinct is kinda filter, check and pass the element to new stream
        but Sorted is not like filter, it waits till every element reach and then start the sort operation because it must be
        if there is no terminal state sort operation won't start as stream apis are lazy
        if the stream is of infinite elements sort operation will never every happen
         */
        Stream.of(1, 1, 5, 5, 2, 2, 3, 3, 6, 6, 7, 8, 9, 10)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //Stream concat
        Stream<Integer> oddStream = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> evenStream = Stream.of(2, 4, 8, 10);
        Stream.concat(oddStream, evenStream).forEach(System.out::println); //just process left one first and then right stream
    }
}
