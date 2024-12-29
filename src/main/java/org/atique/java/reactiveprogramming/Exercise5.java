package org.atique.java.reactiveprogramming;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux()
                .subscribe(
                        System.out::println,
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Done!")
                );
        //or,
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(
                        System.out::println,
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Done!")
                );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux()
                        .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed!");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println("Next value: " + value);
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Complete!");
    }
}