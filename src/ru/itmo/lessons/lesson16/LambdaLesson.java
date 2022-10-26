package ru.itmo.lessons.lesson16;

public class LambdaLesson {
    public static void main(String[] args) {
        // объявить интерфейс Operation
        // с абстрактным методом execute,
        // который принимает на вход два числа с плавающей точкой и
        // возвращает число с плавающей точкой


        // реализация метода execute функционального интерфейса +
        // создание экземпляра типа Operation

        // double execute(double a, double b);

        Operation plus = (first, second) -> first + second;
        System.out.println(plus);

        System.out.println(plus.execute(3, 56));


    }
}
