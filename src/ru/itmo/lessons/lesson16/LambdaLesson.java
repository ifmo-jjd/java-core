package ru.itmo.lessons.lesson16;


import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    private static void calculate(Operation operation, double x, double y) {
        System.out.println("Результат: " + operation.execute(x, y));
    }

    public static void main(String[] args) {
        // объявить интерфейс Operation
        // с абстрактным методом execute,
        // который принимает на вход два числа с плавающей точкой и
        // возвращает число с плавающей точкой


        // реализация метода execute функционального интерфейса +
        // создание экземпляра типа Operation

        // double execute(double a, double b);
        // если метод принимает на вход 1 аргумент, то () можно опустить,
        // в остальных случаях () обязательны
        // типы данных аргументов берутся из контекста (метода в интерфейсе)
        // если тело метода состоит из 1й инструкции, то {} можно опустить,
        // если инструкций несколько, {} обязательны
        // если {} отсутствуют, return - по умолчанию
        // при наличии {} return прописывается явно (при необходимости)
        Operation plus = (first, second) -> /*return*/ first + second;
        Operation div = (a, b) -> {
            if (b == 0) return 0;
            return a / b;
        };
        System.out.println(plus);
        System.out.println(div);

        System.out.println(plus.execute(3, 56));
        System.out.println(div.execute(0, 56));

        Operation plus01 = new Plus();
        System.out.println(plus01.execute(3, 36));

        // лямбда можно передавать в методы в качестве параметров
        calculate(plus, 45, 90);
        calculate(div, 90, 2);
        calculate((n, m) -> n - m, 90, 2);

        // import java.util.function.Predicate;
        // boolean test(T t);
        // написать реализации метода test
        // проверка на положительное число
        // проверка на отрицательное число
        // проверка на четное число
        Predicate<Integer> isPos = x -> x > 0;
        Predicate<Integer> isNeg = x -> x < 0;
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isPos.test(-90));
        System.out.println(isPos.and(isEven).test(100)); // &&
        System.out.println(isNeg.or(isPos).test(0)); // ||

        // R apply(T t);
        // уменьшение целого числа на 20%
        // увеличение целого числа в 2 раза
        // добавление к положительному числу строки " p."
        Function<Integer, Double> minus20 = x -> x * 0.8;
        // Function<Integer, Double> doubled = x -> Double.valueOf(x * 2);
        Function<Integer, Integer> doubled = x -> x * 2;
        Function<Integer, String> str = x -> {
           if (x <= 0) throw new IllegalArgumentException("Число д.б. положительным");
           return x + " p.";
        };
        System.out.println(doubled.apply(100));
        System.out.println(doubled.andThen(str).apply(12));

    }
}
