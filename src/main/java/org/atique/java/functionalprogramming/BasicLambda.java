package org.atique.java.functionalprogramming;

/**
 * @author atiQue
 * @since 25'Apr 2024 at 9:42 PM
 */

public class BasicLambda {
    public static void main(String[] args) {

        SomeInterface plusOne = x -> x + 1;
        System.out.println("Plus one: " + plusOne.someMethod(100));

        SomeInterface multiplyTwo = x -> x * 2;
        System.out.println("Multiply two: " + multiplyTwo.someMethod(100));

        // treating lambda as first class citizen, declaring, assigning
        multiplyTwo = plusOne;
        System.out.println("Plus one: " + multiplyTwo.someMethod(100));
    }

    interface SomeInterface {
        int someMethod(int value);
    }
}
