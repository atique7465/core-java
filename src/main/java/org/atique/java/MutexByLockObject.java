package org.atique.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 9:43 AM
 */

public class MutexByLockObject {

    private static int value = 0;

    private static final Lock lock = new ReentrantLock();

    static class Counter implements Runnable {

        private void increment() {
            value++;
        }

        private void decrement() {
            value--;
        }

        @Override
        public void run() {
            lock.lock();

            try {
                //critical section
                increment();
                System.out.println(Thread.currentThread().getName() + " incremented to " + value);
                decrement();
                System.out.println(Thread.currentThread().getName() + " decremented to " + value);
            } finally {
                lock.unlock();
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
