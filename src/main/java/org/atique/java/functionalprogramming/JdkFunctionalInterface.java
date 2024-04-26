package org.atique.java.functionalprogramming;

import java.util.function.*;

/**
 * @author atiQue
 * @since 26-Apr-24 11:11 AM
 */

public class JdkFunctionalInterface {
    public static void main(String[] args) {

        //Function: for the lambdas whos takes an arg and return a value
        Function<Integer, Integer> f1 = x -> x + 1;
        System.out.println("Increment: " + f1.apply(1));

        Function<Integer, String> f2 = x -> "Number is :" + x;
        System.out.println(f2.apply(1));

        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
        System.out.println("Incremented by: " + biFunction.apply(1, 2));

        // if arg and return are the same type we can use operators
        BinaryOperator<Integer> operator = (x, y) -> x + y;
        System.out.println("Operator incremented by: " + operator.apply(1, 1));
        /**
         * @FunctionalInterface
         * public interface BinaryOperator<T> extends BiFunction<T,T,T> {}
         * with a cost of:
         * biFunction = operator; //its fine
         * but,
         * operator = biFunction; //error!
         */

        //Consumer: for the lambdas who takes an input, no return value
        Consumer<String> c1 = str -> System.out.println("Hi " + str);
        c1.accept("atiQue!");

        BiConsumer<String, String> c2 = (str1, str2) -> System.out.println("Hi " + str1 + " " + str2);
        c2.accept("atiQue", "vai!");

        //Supplier: for the lambdas with no arg but a return value. No support for BiNary as lambda return one value
        Supplier<Double> p1 = () -> Math.random();
        System.out.println("Produced number: " + p1.get());

        //Predicate: for the lambdas with an arg and returns true/false. this is kind of Function but special for filter operations
        Predicate<Integer> pr1 = x -> x % 2 == 0;
        System.out.println("Is even: " + pr1.test(2));

        BiPredicate<Integer, Integer> pr2 = (x, y) -> x % y == 0;
        System.out.println("Is divisible by: " + pr2.test(10, 2));
    }
}
