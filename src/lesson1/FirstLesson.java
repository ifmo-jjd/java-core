package lesson1;

// комментарий
/*
многострочный
комментарий
*/

/**
 * документирование
 * кода
 */

public class FirstLesson {
    // точка входа в программу
    // psvm + Enter
    public static void main(String[] args) { // ctrl + alt + L
        // sout + Enter
        System.out.println("First Lesson"); // вывод данных в консоль

        // объявление переменных: типДанных имяПеременной
        int size; // объявление переменных
        size = 56; // переменной size присвоили значение 56
        System.out.println(size);

        int count = 71899; // объявили переменную типа count и присвоили ей значение
        int length = 134, width = 300;

        count = 800_000; // count = 800000; числа можно разделять _ для удобства чтения
        System.out.println(count);

        // byte data = 315; // ошибка, превышен допустимый диапазон

        // если значение переменной типа long выходит за пределы int,
        // необходимо добавлять символ L или l для обозначения типа long
        long veryBig = 67_000_000_000L;

        double price = 89.34;

        // необходимо добавлять символ F или f для обозначения типа
        float temp = -78.3f;

        System.out.println(price / 0); // Infinity
        // System.out.println(veryBig / 0); // java.lang.ArithmeticException: / by zero

        price = 89.34; // double
        count = 8700; // int

        // автоматическое приведение типов (возможно только при совместимых типах
        // и расширении контейнера)
        price = count;
        System.out.println(price);

        // явное приведение типов (возможно только при совместимых типах)
        byte small = (byte) count;
        System.out.println(small);

        // Операторы
        int a = 9, b = 4;
        int c1 = a / b; // результат деления целых чисел - целое число
        System.out.println(c1); // 2

        double c2 = (double) a / b;
        System.out.println(c2); // 2.25

        byte x = 6, y = 10;
        // byte z = (byte) x + y; // сложение byte или short дает int
        byte z = (byte) (x + y); // сложение byte или short дает int
        System.out.println(z);


        // Остаток от деления
        length = 9;
        width = 2;
        System.out.println(length % width); // 1
        // 4.5 + 4.5
        // 0.5 + 0.5 = 1

        System.out.println(7 % 4); // 3
        System.out.println(8 % 2); // 0
        System.out.println(9 % 2); // 1
        System.out.println(903 % 10); // 3

        int number = 45; // 4 + 5
        number = number / 10 + number % 10;
        System.out.println(number);

        // Арифметические операторы и операторы присваивания
        int num = 10;
        num += 10; // num = num + 10;
        num -= 10; // num = num - 10;
        num *= 10; // num = num * 10;
        num /= 10; // num = num / 10;
        num %= 10; // num = num % 10;
        System.out.println(num); // 0

    }
}




