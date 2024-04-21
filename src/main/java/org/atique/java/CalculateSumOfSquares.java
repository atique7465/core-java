package org.atique.java;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 4:08 PM
 */

public class CalculateSumOfSquares extends RecursiveTask<Integer> {

    private List<Integer> list;
    private int start;
    private int end;

    CalculateSumOfSquares(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= 4) {
            System.out.println(Thread.currentThread().getName() + " " + start + " and " + end);
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += list.get(i) * list.get(i);
            }
            return sum;
        }

        int middle = (start + end) / 2;
        CalculateSumOfSquares subTask1 = new CalculateSumOfSquares(list, start, middle);
        CalculateSumOfSquares subTask2 = new CalculateSumOfSquares(list, middle, end);

        subTask1.fork();
        subTask2.fork();

        return subTask1.join() + subTask2.join();
    }
}
