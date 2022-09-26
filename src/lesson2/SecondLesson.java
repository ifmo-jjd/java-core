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


        // IF... ELSE IF... ELSE

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

        // SWITCH


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

        code = 3333;
        if ((code == 2222) || (code == 3333) || (code == 4444)) {
            System.out.println("Вы вошли в систему");
        }

        if (code == 2222 || code == 3333 || code == 4444) {
            System.out.println("Вы вошли в систему");
        }


        age = 2;

        // синтаксис switch в стиле лямбда выражений
        switch (age){
            case 0, 1 -> System.out.println(200);
            case 2, 3 -> System.out.println(150);
            case 4, 5, 9 -> System.out.println(100);
            default -> System.out.println(0);
        }

        age = 2;
        int count = switch (age){
            case 0, 1 -> 200;
            case 2, 3 -> 150; /* но не System.out.println(150) */
            case 4, 5, 9 -> 100 + 100;
            default -> 0;
        };
        System.out.println(count);

        count =  switch (age){
            case 0, 1 -> {
                System.out.println("Результат на 0 - 1 год: " + 200);
                yield 200;
            }
            case 2, 3 -> {
                System.out.println("Результат на 2 - 3 года: " + 150);
                yield 150;
            }
            case 4, 5 -> {
                System.out.println("Результат на 4 - 5 лет: " + 100);
                yield 100;
            }
            default -> {
                System.out.println("Результат для собаки старше 5 лет: " + 0);
                yield 100;
            }
        };
        System.out.println(count);

        int k = 1;
        // область видимости переменных - блок { }
        {
            int l = 2; // если переменная объявлена внутри {}
            System.out.println(k);
            System.out.println(l);
        }
        // System.out.println(l); // снаружи ее не существует
        System.out.println(k);

    }
}
