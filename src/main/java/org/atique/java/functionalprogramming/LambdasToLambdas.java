package org.atique.java.functionalprogramming;

import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * @author atiQue
 * @since 26-Apr-24 12:54 PM
 */

public class LambdasToLambdas {
    public static void main(String[] args) {

        Consumer<Integer> logValueChange = value -> System.out.println("value changed to :" + value);

        Consumer<String> logMessage = str -> System.out.println(str + " : " + new Date());
        Runnable logSTart = () -> logMessage.accept("START");
        Runnable logEnd = () -> logMessage.accept("END");

        BiConsumer<UnaryOperator<Integer>, Integer> logger = (operation, value) -> {
            logSTart.run();
            logValueChange.accept(operation.apply(value));
            logEnd.run();
        };

        logger.accept(x -> x + 1, 10);

        logger.accept(x -> x * 2, 10);
    }
}
