package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int number) {
        return Math.abs(number - x);
    }

    public static int sum(int number) {
        return x + number;
    }

    public int divide(int number) {
        return number / x;
    }

    public int multipla(int number) {
        return x * number;
    }

    public int sumAllOperation(int number) {
        return sum(number) + minus(number) + divide(number) + multipla(number);
    }

    public static void main(String[] args) {
        int rsl = minus(10);
        System.out.println(rsl);
        rsl = sum(10);
        System.out.println(rsl);
        Calculator calculator = new Calculator();
        rsl = calculator.divide(10);
        System.out.println(rsl);
        rsl = calculator.multipla(10);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(10);
        System.out.println(rsl);
    }
}
