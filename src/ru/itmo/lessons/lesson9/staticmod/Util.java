package ru.itmo.lessons.lesson9.staticmod;

public class Util {
    public static int max;
    public static int min;
    public final static double PI;

    // статический блок для инициализации статических свойств (переменных)
    // инструкции выполняются один раз при загрузке класса
    static {
        PI = 3.14;
    }

    // static метод нельзя переопределить в дочернем классе
    public static int random(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}