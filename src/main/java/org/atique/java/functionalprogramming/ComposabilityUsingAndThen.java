package org.atique.java.functionalprogramming;

import java.util.function.Function;

/**
 * @author atiQue
 * @since 26-Apr-24 2:56 PM
 */

public class ComposabilityUsingAndThen {

    public static void main(String[] args) {

        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> tripleIt = x -> x * 3;

        Function<Integer, Integer> combine = increment
                .andThen(doubleIt)
                .andThen(tripleIt);

        System.out.println("Combine result: " + combine.apply(10));

        Function<Integer, Integer> compose = increment.compose(doubleIt.compose(tripleIt));
        System.out.println("Compose result: " + compose.apply(10));
    }
}
