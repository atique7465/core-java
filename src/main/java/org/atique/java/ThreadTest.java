package org.atique.java;

/**
 * @author atiQue
 * @since 20'Apr 2024 at 6:23 PM
 */

public class ThreadTest {

    public static void main(String[] args) {

        // way 01
        Thread thread = new Thread(new Something());
        thread.start();

        // way 02
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is something 02");
            }
        });
        thread2.start();

        // way 03
        new Thread(() -> System.out.println("This is something 03")).start();
    }

    static class Something implements Runnable {

        @Override
        public void run() {
            System.out.println("This is something");
        }
    }
}
