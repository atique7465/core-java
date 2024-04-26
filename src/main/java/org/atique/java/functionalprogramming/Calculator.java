package org.atique.java.functionalprogramming;

/**
 * @author atiQue
 * @since 25'Apr 2024 at 10:28 PM
 */

public class Calculator {

    private static int Calculate(MathOperation op, int a, int b){
        return op.doOperation(a, b);
    }

    public static void main(String[] args) {
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> a * b;
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("Addition : " + Calculate(addition, 10, 10));
        System.out.println("Subtraction : " + Calculate(subtraction, 20, 10));
        System.out.println("Multiplication : " + Calculate(multiplication, 20, 10));
        System.out.println("Division : " + Calculate(division, 20, 10));
    }
}

@FunctionalInterface
interface MathOperation {
    int doOperation(int a, int b);
}
