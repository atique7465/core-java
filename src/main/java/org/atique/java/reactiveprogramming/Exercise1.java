package org.atique.java.reactiveprogramming;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("-1"));
        //or,
        Integer value = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .forEach(e -> System.out.println(e.getFirstName()));
        //or,
        StreamSources.userStream()
                .map(User::getLastName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(num -> num == u.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);
        //or, a buggy way using flatmap
        StreamSources.intNumbersStream()
                .flatMap(n -> StreamSources.userStream().filter(u -> u.getId() == n))
                .map(User::getLastName)
                .forEach(System.out::println);

    }

}
