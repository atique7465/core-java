package org.atique.java.concurrency;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 12:57 PM
 */

public class ExecutorServices {
    public static void main(String[] args) {

        ScheduledExecutorService reporter = Executors.newSingleThreadScheduledExecutor();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        reporter.scheduleAtFixedRate(
                () -> System.out.println("Report: Total active: " + pool.getActiveCount() + " Total completed: " + pool.getCompletedTaskCount()),
                1,
                5,
                TimeUnit.SECONDS
        );

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the task time: ");
            long taskTime = sc.nextLong();
            if (taskTime == 0) {
                System.out.println("Killing the process ....");
                break;
            }

            pool.execute(() -> {
                try {
                    Thread.sleep(taskTime);
                    System.out.println("task: " + taskTime + " finished!");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }


        pool.shutdown();
        reporter.shutdown();
        System.out.println("Process killed ...");
    }
}
