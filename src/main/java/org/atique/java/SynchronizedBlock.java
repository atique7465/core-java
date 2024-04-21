package org.atique.java;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 9:43 AM
 */

public class SynchronizedBlock {

    private static int value = 0;

    static class Counter implements Runnable {

        private void increment() {
            value++;
        }

        private void decrement() {
            value--;
        }

        @Override
        public void run() {
            //this --> unique objectRef to act as a key
            //by using "this" we achieved separate locking mechanism for different instances
            synchronized (this) {
                //critical section
                increment();
                System.out.println(Thread.currentThread().getName() + " incremented to " + value);
                decrement();
                System.out.println(Thread.currentThread().getName() + " decremented to " + value);
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter, "One").start();
        new Thread(counter, "Two").start();
        new Thread(counter, "Three").start();
        new Thread(counter, "Four").start();
    }
}
