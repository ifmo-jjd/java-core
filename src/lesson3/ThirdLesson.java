package lesson3;

import java.util.Scanner;

public class ThirdLesson {
    public static void main(String[] args) {
        // Операторы:
        // ИНКРЕМЕНТ ++ увеличивает значение переменной на 1
        // ДЕКРЕМЕНТ -- уменьшает значение переменной на 1


        int a = 1;
        System.out.println(a++); // 1 // постфиксная форма
        System.out.println(a); // 2

        a = 1;
        System.out.println(++a); // 2  // префиксная форма
        System.out.println(a); // 2

        a = 1;
        System.out.println(a--); // 1 // постфиксная форма
        System.out.println(a); // 0

        a = 1;
        System.out.println(--a); // 0  // префиксная форма
        System.out.println(a); // 0

        // ВВОД данных с клавиатуры
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число");
        int userNumber = in.nextInt();
        System.out.println(userNumber * userNumber);

        // ЦИКЛЫ (while, do while, for)

        int printsCount = 3;
        while (printsCount > 0){
            // тело цикла
            System.out.println("=======");
            printsCount--;
            // printsCount -= 1;
            // printsCount = printsCount - 1;
        }


        // не будет выполнено ни одной итерации
        /* while (false) {
            System.out.println("false");
        } */
        /*int i = 18;
        while (i < 0) {
            System.out.println("false");
        }*/

        // бесконечный цикл
        /* while (true) {
            System.out.println("бесконечный цикл");
        } */

        // бесконечный цикл
        // int i = 18;
        /* while (i > 0) {
            System.out.println("бесконечный цикл");
        } */

        while (true) {
            System.out.println("Введите целое положительно число или" +
                    "0 для выхода из программы");
            userNumber = in.nextInt();
            // директивы break и continue
            if (userNumber == 0) break; // завершение текущего цикла
            if (userNumber < 0) continue; // переход на следующую итерацию,
                                          // с проверкой условия
            System.out.println(userNumber * userNumber);
        }

        // вывести в консоль все чётные числа от start до end
        int start = 1, end = 13;
        while (start <= end){
            if (start % 2 == 0) System.out.println(start);
            start++;
        }

        // for (;;){} - бесконечный цикл

        for (int s = 1, e = 13; // инициализация счетчиков
             s <= e; // булевое выражение (условие)
             s++ // обновление счетчиков
        ) {
            if (s % 2 == 0) System.out.println(s);
        }

        // BREAK и выход их внешних циклов
        a = 100;
        zero:
        while (a > 50) {
            System.out.println(a);
            a -= 10;
        }

        int plusCount = 4;
        first: // имя цикла
        while (true) {
            System.out.println("+++ Введите число +++");
            userNumber = in.nextInt();
            second: // имя цикла
            while (true) {
                if (userNumber <= 1) break; // выход из текущего цикла
                // (внешний цикл снова запросит число, далее программа снова начнет выполнение цикла second)

                if (userNumber > 2) break second; // выход из цикла с именем second, т.е. текущего цикла
                // (внешний цикл снова запросит число, далее программа снова начнет выполнение цикла second)

                if (userNumber == 2) break first; // выход из цикла с именем first
                // (внешний цикл прерывается, программа перестает запрашивать числа)

                // if (userNumber == 3) break zero; так нельзя, zero не связан с циклами first и second
            }
            System.out.println(userNumber);
        }

    }
}
