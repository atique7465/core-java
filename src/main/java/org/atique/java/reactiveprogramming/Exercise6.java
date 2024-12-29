package org.atique.java.reactiveprogramming;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.atique.java.reactiveprogramming.ReactiveSources.unresponsiveFlux;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        //String val = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        List<String> result = unresponsiveFlux()
                .collectList()
                .block(Duration.ofSeconds(5));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
