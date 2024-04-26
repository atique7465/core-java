package org.atique.java.functionalprogramming;

import java.util.function.Supplier;

/**
 * @author atiQue
 * @since 26-Apr-24 3:21 PM
 */

public class ClosureTest {

    private static Supplier<Integer> fun() {
        int value = 0;
        Supplier<Integer> supplier = () -> value + 1;
        //value = 2; //!error
        return supplier;
    }

    public static void main(String[] args) {

        //Test 01
        System.out.println("Test 01 : " + fun().get());
        System.out.println("Test 01 : " + fun().get());

        //test 02
        SomeCounter someCounter = new SomeCounter();
        System.out.println("Test 02 : " + someCounter.counter().get());
        someCounter.increment();
        System.out.println("Test 02 : " + someCounter.counter().get());
        someCounter.increment();
        System.out.println("Test 02 : " + someCounter.counter().get());


    }
}

class SomeCounter {

    private int count = 0;

    public void increment() {
        count++;
    }

    public Supplier<Integer> counter() {
        Supplier<Integer> supplier = () -> count + 1;
        return supplier;
    }
}
