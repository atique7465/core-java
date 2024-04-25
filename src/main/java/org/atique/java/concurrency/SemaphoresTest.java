package org.atique.java.concurrency;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 9:43 AM
 */

public class SemaphoresTest {

    private static Scanner sc = new Scanner(System.in);
    private static int value = 100;

    private static Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter the task time: ");
            long taskTime = sc.nextLong();

            if(taskTime == 0) break;

            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(taskTime);
                    System.out.println("Tasktime: " + taskTime + " accessed value: " + value);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            new Thread(runnable).start();
        }

    }
}
