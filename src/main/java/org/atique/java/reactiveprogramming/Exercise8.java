package org.atique.java.reactiveprogramming;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(
//                        System.out::println,
//                        err -> System.out.println("Error!!: " + err.getMessage())
//                );
        //or,
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(ex -> System.out.println("Error!!: " + ex.getMessage())) // won't shallow the exception like before
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((ex, iteme) -> System.out.println("Error!!: " + ex.getMessage()))
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
