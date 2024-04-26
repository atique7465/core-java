package org.atique.java.functionalprogramming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author atiQue
 * @since 26'Apr 2024 at 9:18 PM
 */

public class WayOfCreatingStream {
    public static void main(String[] args) {

        //using list
        List<String> list = List.of("AA", "BB", "CC");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        //using set
        Set<String> set = Set.of("Set AA", "Set BB", "Set CC");
        stream = set.stream();
        stream.forEach(System.out::println);

        //using array
        int[] array = {1, 2, 3};
        Arrays.stream(array).forEach(System.out::println);

        /*
        using stream api Stream.of()
        this way implies that stream has nothing to do with the source of elements,
        stream is itself a thing, a data structure to process elements
        */
        Stream.of("api aa", "api bb", "api cc").forEach(System.out::println);

        //Using built in file apis that return stream
        try (Stream<String> linesStream = Files.lines(Paths.get("README.md"))) {
            linesStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //By passing a supplier in Stream,generate()
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //Using Stream.iterate(seed, unaryOperator)
        Stream.iterate(1, x -> x + 1)
                .limit(5)
                .forEach(System.out::println);

        //ToList
        List<Integer> upToFive = Stream.iterate(1, x -> x + 1)
                .limit(5)
                .toList();
        System.out.println(upToFive);
    }
}
