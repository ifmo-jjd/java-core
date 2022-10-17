package ru.itmo.lessons.lesson12;

public class Actions {
    public static double sum (double a, double b) throws CalculatorException{
        if (a < 0 || b < 0) {
            throw new CalculatorException("Числа дб положительными");
        }
        return a + b;
    }

    public static double minus(double a, double b) throws CalculatorException{
        if (a < 0 || b < 0) {
            throw new CalculatorException("Числа дб положительными");
        }
        return a - b;
    }

    public static int random(int min, int max) throws CalculatorException{
        return (int) (min + Math.random() * minus(max, min));
    }
}
