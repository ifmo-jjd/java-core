package lesson2;

public class SecondLesson {
    public static void main(String[] args) {
        // Операторы сравнения возвращают тип boolean

        int a = 78;
        int b = 9000;
        int c = 78;

        System.out.println(a > b); // false
        System.out.println(a >= c); // true
        System.out.println(a <= c); // true

        System.out.println(a == b); // false
        System.out.println(a != b); // true


        // тернарный оператор ?
        int start = 3, end = 100;
        int res = start > end ? -1 : 0;

        // Дана переменная sum - сумма покупки.
        // Если сумма покупки больше 100000,
        // то вывести в консоль сумму к оплате с учетом скидки в 10%,
        // в противном случае вывести в консоль сумму к оплате без скидки.

        int sum = 14000;
        double result = sum > 100_000 ? sum * 0.9 : sum;
        System.out.println(result);


        int x = 50, y = 100, z = 91;

        // && оператор и
        boolean resB = (x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0);
        // true && true && false
        // true && false
        System.out.println(resB); // fasle

        resB = (x < z) && (y > z);
        // true && true
        System.out.println(resB); // true

        // || оператор или
        int code = 3333, age = 34;
        resB = (code == 2222) || (code == 3333) || (code == 4444);
        // false || true || false
        // true || false
        System.out.println(resB); // true


        resB = (code != 3333) || (age < 18);
        // false || false
        System.out.println(resB); // false

        // ! оператор не - меняет значение на противоположное
        System.out.println(!resB); // true

        boolean isActive = false, isConnected = true;
        resB = !isActive || !isConnected;
        // true || false
        System.out.println(resB); // true

        // int code = 3333, age = 34;
        resB = !(code != 3333) || (age < 18);
        // true || false
        System.out.println(resB); // true


        resB = !((code != 3333) || (age < 18));
        // false || false
        // false
        System.out.println(resB); // true


        // if switch

        int state = 55;
        // если state равен 0, вывести в консоль "Закрытие приложения"
        // если state равен 1, вывести в консоль "Открытие приложения"
        // в остальных случаях вывести в консоль "Ошибка статуса"

        if (/* булевое выражение */ state == 0) {
            System.out.println("Закрытие приложения");
        } else if (state == 1) {
            System.out.println("Открытие приложения");
        } else {
            System.out.println("Ошибка статуса");
        }

        // можно не ставить {}, если инструкция одна
        if (/* булевое выражение */ state == 0) System.out.println("Закрытие приложения");
        else if (state == 1) System.out.println("Открытие приложения");
        else System.out.println("Ошибка статуса");

        // на принято использовать if со скобками и без
        if (/* булевое выражение */ state == 0) System.out.println("Закрытие приложения");
        else if (state == 1) {
            System.out.println("Открытие приложения");
        } else System.out.println("Ошибка статуса");

        // switch

        // если state равен 0, вывести в консоль "Закрытие приложения"
        // если state равен 1 или state равен 100, вывести в консоль "Открытие приложения"
        // в остальных случаях вывести в консоль "Ошибка статуса"
        state = 100;
        switch (state) {
            case 0:
                System.out.println("Закрытие приложения");
                break;
            case 1:
            case 100:
                System.out.println("Открытие приложения");
                break;
            default: // необязательный блок
                System.out.println("Ошибка статуса");
        }

    }
}
