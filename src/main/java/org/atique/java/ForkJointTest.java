package org.atique.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author atiQue
 * @since 21'Apr 2024 at 4:08 PM
 */

public class ForkJointTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        CalculateSumOfSquares task = new CalculateSumOfSquares(list, 0, list.size() - 1);
        Integer result = forkJoinPool.invoke(task);

        System.out.println("Result is: " + result);

    }
}
