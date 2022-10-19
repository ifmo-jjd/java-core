package ru.itmo.lessons.pwrappers;

public class PrimitiveWrappers {
    public static void main(String[] args) {
        // byte - class Byte
        // short - class Short
        // int - class Integer
        // long - class Long
        // float - class Float
        // double - class Double
        // boolean - class Boolean
        // char - class Character

        // использование примитивов или соответствующих классов-оберток
        // в программах необходимо использовать примитивы за исключением случаев:
        // 1. когда использование примитивов невозможно
        // 2. когда необходимо воспользоваться методами классов-оберток


        int num = 567;
        Integer count02 = 54;
        // Integer count01 = new Integer(54); устаревший способ

        // автоупаковка - переменной класса-обертки присваивается значение примитива
        Integer age = 38; // автоупаковка
        age = num; // автоупаковка

        // автораспаковка - переменной примитивного типа присваивается значение обертки
        double price;
        Double someDouble = 56.89; // автоупаковка
        price = someDouble; // автораспаковка

        // Правила автоупаковки и автораспаковки
        // 1. автоупаковка не работает, если примитив не соответствует типу класса обертки
        // Byte byteObj = 500;
        // Byte byteObj = 400;
        byte one = 1;
        // Integer i = one;
        // Integer i = (Integer) one;
        Integer i = (int) one;

        // 2. на автораспаковку данное правило не распространяется
        Byte two = 2;
        int num2 = two; // автораспаковка + неявное приведение типов

        Integer three = 3;
        // byte num3 = (Byte) ((Number)three); // ???

        // 3. параметры (аргументы) методов подлежат правилам автораспаковки и автоупаковки
        printSqrt(78);
        Integer integer = 45;
        printNum(integer);

        // 4. автораспаковка и автоупаковка не работают с массивами
        double[] doubles = {45.88, 123.701, 3.8};
        // printDoubles(doubles); автоупаковка не работает

        Integer first = 34;
        Integer second = 34;
        // оператор == сравнивает ссылки
        System.out.println(first == second); // true

        first = 200;
        second = 200;
        // оператор == сравнивает ссылки
        System.out.println(first == second); // false

        // для сравнения ссылочных типов используем метод equals

    }

    public static void printDoubles(Double[] doubles){
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    public static void printSqrt(Integer i){
        Integer res = i * i;
        System.out.println(res);
    }
    public static void printNum(int i){
        System.out.println(i);
    }
}
