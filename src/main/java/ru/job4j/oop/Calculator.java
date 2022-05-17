package ru.job4j.oop;

public class Calculator {

     private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultSum = sum(10);
        int resultMultiply = calculator.multiply(10);
        int resultMinus = minus(10);
        int resultDivide = calculator.divide(10);
        int resultSumAllOperation = calculator.sumAllOperation(10);
        System.out.println(resultSum);
        System.out.println(resultMultiply);
        System.out.println(resultMinus);
        System.out.println(resultDivide);
        System.out.println(resultSumAllOperation);
    }
}
