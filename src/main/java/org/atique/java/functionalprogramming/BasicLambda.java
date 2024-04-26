package org.atique.java.functionalprogramming;

/**
 * @author atiQue
 * @since 25'Apr 2024 at 9:42 PM
 */

public class BasicLambda {
    public static void main(String[] args) {

        // treating lambda as first class citizen, declaring, assigning

        SomeInterface plusOne = x -> x + 1;
        System.out.println("Plus one: " + plusOne.someMethod(100));

        SomeInterface multiplyTwo = x -> x * 2;
        System.out.println("Multiply two: " + multiplyTwo.someMethod(100));

        /**
         * we can do this as long as the Interface type is same,
         * if 2 variable comes from different interface with same SAM signature they are not interchangeable
         * This rule is for type safety in java
         */
        multiplyTwo = plusOne;
        System.out.println("Plus one: " + multiplyTwo.someMethod(100));
    }

    interface SomeInterface {
        int someMethod(int value);
    }
}
