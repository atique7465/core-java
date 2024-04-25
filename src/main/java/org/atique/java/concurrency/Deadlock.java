package org.atique.java.concurrency;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 10:55 AM
 */

public class Deadlock {

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test::method1).start();
        new Thread(test::method2).start();

        System.out.println("There is deadlock as the program is still running!!!");
    }

    static class Test {
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void method1() {
            synchronized (lock1) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ignored) {
                }
                synchronized (lock2) {
                    System.out.println("its method1");
                }
            }
        }

        public void method2() {
            synchronized (lock2) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ignored) {
                }
                synchronized (lock1) {
                    System.out.println("its method2");
                }
            }
        }
    }
}

