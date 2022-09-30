package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class FifthLesson {
    public static void main(String[] args) {

        int a = 56, b = 34;
        System.out.println(a == b); // false

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println(scanner1 == scanner2); // false

        String string1 = "java";
        String string2 = "java";
        String string3 = "Java";
        System.out.println(string1 == string2); // true
        System.out.println(string1 == string3); // false

        // Массивы
        int[] ints1 = new int[7]; // где 7 - длина массива,
                           // создан массив на 7 элементов
                     // и заполнен значениями по умолчанию
        // размер массива изменить нельзя!!!

        // целочисленные массивы заполняются 0
        // массивы для float/double заполняются 0.0
        // массивы для boolean заполняются false
        // массивы для ВСЕХ ссылочных типов заполняются null
        String[] strings1 = new String[3]; // [null, null, null]

        System.out.println(ints1); // [I@723279cf
        System.out.println(Arrays.toString(ints1)); // [0, 0, 0, 0, 0, 0, 0]

        int[] ints2 = {5, 78, 1, 5, 90, -3};
        System.out.println(Arrays.toString(ints2));

        ints2 = new int[3];
        // ints2 = {1, 10, 100};
        ints2 = new int[]{1, 10, 100};
        System.out.println(Arrays.toString(ints2));

        // длина массива - положительное значение типа int
        int len = 10;
        int[] ints3 = new int[len];
        String[] strings2 = new String[len * 2];
        System.out.println(Arrays.toString(strings2));
        // int[] ints3 = new int[-9]; // java.lang.NegativeArraySizeException

        System.out.println(ints3.length); // 10
        System.out.println(strings2.length); // 20

        // доступ к элементам массива
        strings2 = new String[len * 2];
        strings2[4] = "red";
        strings2[0] = "yellow";
        strings2[10] = "black";
        System.out.println(Arrays.toString(strings2));

        System.out.println(strings2[12]); // null
        System.out.println(strings2[0]); // yellow

        // выход за пределы массива
        // java.lang.ArrayIndexOutOfBoundsException
        // System.out.println(strings2[200]);

        int[] ints4 = {4, 7, 0, -12, 67, 44};
        // вывести в консоль случайный элемент массива ints4
        // Math.random()

        int index = (int) (Math.random() * ints4.length);
        System.out.println(index);

        System.out.println(ints4[index]);

        // {4, 7, 0, -12, 67, 44};
        // перебор элементов массива
        // for позволяет изменять значения элементов массива
        // for позволяет перебрать массив начиная с последнего элемента и тд
        for (int arrIndex = 0; arrIndex < ints4.length; arrIndex++) {
            System.out.println(ints4[arrIndex]);
            if (ints4[arrIndex] > 0) ints4[arrIndex] += 100;
        }

        System.out.println(Arrays.toString(ints4));



    }
}
