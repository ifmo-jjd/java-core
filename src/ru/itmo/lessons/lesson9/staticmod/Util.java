package ru.itmo.lessons.lesson9.staticmod;

import java.util.Arrays;

public class Util {
    public static int max;
    public static int min;
    public final static double PI;

    private Util(){}

    // статический блок для инициализации статических свойств (переменных),
    // вызова статических методов
    // инструкции выполняются один раз при загрузке класса
    static {
        PI = 3.14;
    }

    // static метод нельзя переопределить в дочернем классе
    public static int random(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}