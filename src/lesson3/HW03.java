import java.util.Scanner;

public class HW03 {
    public static void main(String[] args) {

        // FIXME:: Вывести все неотрицательные элементы последовательности 90 85 80 75 70 65 60 и тд
        
        for (int i = 90; i >= 0; i = i - 5) {
            System.out.println(i);
        }


        // FIXME:: Вывести на экран первые 10 элементов последовательности 2 4 6 8 10 и тд

        for (int j = 2, count = 0; count < 10; count++, j += 2) {
            System.out.println(j);
        }


        // FIXME:: Для введённого пользователем с клавиатуры целого положительного числа посчитайте сумму всех его цифр

        int number = 16321; // пользователь вводит число с клавиатуры
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println(sum);


        // FIXME:: Тарелки и моющее средство

        int plates = 55;
        double soap = 2;
        while (plates >= 1 && soap >= 0.5) {
            soap -= 0.5;
            plates--;
            System.out.println("Средства: " + soap);
        }
        System.out.println("Тарелок: " + plates + ". Средства: " + soap);


        // FIXME:: Программа загадывает число в диапазоне [1;9] ...

        Scanner in = new Scanner(System.in);
        int secret = 7;

        while (true) {
            System.out.println("Введите целое число от 1 до 9, для выхода из программы введите 0");
            int userNumber = in.nextInt();

            if (userNumber < 0 || userNumber > 9) {
                System.out.println("Введено число вне диапазона");
                continue;
            }

            if (userNumber == 0) {
                System.out.println("Выход из программы");
                break;
            }

            if (secret > userNumber) {
                System.out.println("Загаданное число больше");
                continue;
            }

            if (secret < userNumber) {
                System.out.println("Загаданное число меньше");
                continue;
            }

            System.out.println("Вы угадали");

        }


        // FIXME:: Пользователь загадывает число в диапазоне [2;100] ...

        int start = 2;
        int end = 101;
        int middle;

        while (true) {
            middle = (start + end) / 2;
            System.out.println("Это число равно " + middle + "?");
            int answer = in.nextInt();
            if (answer == 1) break;
            System.out.println("Это число больше " + middle + "?");
            answer = in.nextInt();
            if (answer == 1) start = middle;
            else if (answer == 0) end = middle;
        }

    }
}
