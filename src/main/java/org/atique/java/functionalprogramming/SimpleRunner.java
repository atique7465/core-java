package org.atique.java.functionalprogramming;

/**
 * @author atiQue
 * @since 25'Apr 2024 at 10:11 PM
 */

public class SimpleRunner {

    private static void Runner(Task task) {
        task.run();
    }

    public static void main(String[] args) {
        Task task = () -> System.out.println("Hello World!");
        Runner(task);

        // we can pass lambda expression as like any other method argument as it is first class citizen
        Runner(() -> System.out.println("Hello World Again!"));
    }
}

@FunctionalInterface
interface Task {
    void run();

//  void run2(); // we cant define another method signature as consumer(Implementation) will complain, hey which do i match ?

    // But we can have default functions
    default void fun(){
        System.out.println("Some Default Function!");
    }
}
