package org.atique.java;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 12:57 PM
 */

public class CallableAndFuture {
    public static void main(String[] args) {

        ConcurrentHashMap<Integer, Future<Long>> futures = new ConcurrentHashMap<>();
        ScheduledExecutorService reporter = Executors.newSingleThreadScheduledExecutor();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        reporter.scheduleAtFixedRate(
                () -> {
                    for (Map.Entry<Integer, Future<Long>> entry : futures.entrySet()) {
                        Future<Long> future = entry.getValue();
                        if (future.isDone()) {
                            try {
                                System.out.println("Task: " + entry.getKey() + " finished with result: " + future.get());
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                            futures.remove(entry.getKey());
                        }
                    }
                },
                1,
                1,
                TimeUnit.SECONDS
        );

        Scanner sc = new Scanner(System.in);
        int taskId = 0;
        while (true) {
            System.out.println("Enter the task time: ");
            long taskTime = sc.nextLong();
            if (taskTime == 0) {
                System.out.println("Killing the process ....");
                break;
            }

            Callable<Long> c = () -> {
//                Thread.sleep(taskTime);
                return taskTime;
            };

            Future<Long> future = pool.submit(c);
            futures.put(taskId++, future);
        }


        pool.shutdown();
        reporter.shutdown();
        System.out.println("Process killed ...");
    }
}
