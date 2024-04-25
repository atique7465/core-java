package org.atique.java.concurrency;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 12:57 PM
 */

public class CompletableFutureTest {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the task time: ");
            long taskTime = sc.nextLong();
            if (taskTime == 0) {
                System.out.println("Killing the process ....");
                break;
            }

            CompletableFuture.supplyAsync(() -> {
                        try {
                            Thread.sleep(taskTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return taskTime;
                    }, pool)
                    .thenAccept((result) -> System.out.println("Task: " + result + " finished"));

            System.out.println("Task: " + taskTime + " submitted!");
        }


        pool.shutdown();
        System.out.println("Process killed ...");
    }
}
