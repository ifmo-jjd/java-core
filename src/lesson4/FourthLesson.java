package lesson4;

public class FourthLesson {
    public static void main(String[] args) {
        // char (примитивный тип данных) 16 бит - символ Unicode

        char char1 = 'J'; // сам символ в одинарных кавычках,
        // но "J" - тип String
        char char2 = 74; // номер символа в диапазоне от 0 65535
        char char3 = '\u0044'; // 16ричное представление в escape последовательности

        System.out.print(char1); // J
        System.out.print(char2); // J
        System.out.print(char3); // D

        System.out.println("\nСтроки");

        // Строка - упорядоченная последовательность символов в "" кавычках
        // Строка - ссылочный тип, экземпляр класса String
        // Создание строк:
        // 1. в двойных кавычках "Строка"
        // 2. через конструктор new String() -  используется только, если
        // создание строки через "" невозможен

        // Строки неизменны, можно лишь создать новую на основе существующей
        // строка -> СТРОКА -> СтрокА

        // Хранение строк до 9 версии Java: массив char в кодировке UTF-16,
        // где каждый char был представлен двумя байтами

        // Хранение строк начиная с 9 версии Java: массив byte
        // в кодировке UTF-16 или кодировке LATIN-1

        String string1 = "Строка";
        String string2 = "Строка";
        String string3 = new String("Строка");

        // ссылочные типы хранятся в heap (куча) памяти
        // в heap памяти находится пул строк

        // ссылочные типы не стравнивают через ==,
        // т.к оператор == сравнивает ссылки, а не фактические значения
        System.out.println(string1 == string2); // true
        System.out.println(string1 == string3); // false

        // интернирование строк
        String internString = string3.intern();
        System.out.println(internString == string1); // true

        string1 = "Строка";
        string2 = "Строка";
        // Сравнение строк:
        System.out.println(string1.equals(string2));
        // сравнение с учетом регистра: true - если равны, false - если нет
        System.out.println(string1.equalsIgnoreCase(string2));
        // сравнение без учета регистра регистра: true - если равны, false - если нет

        if (string1.equals(string2)) System.out.println("Строки равны");

        string2 = null;
        // System.out.println(string2.equals("Строка")); // java.lang.NullPointerException
        System.out.println("Строка".equals(string2));

        // сравнение ссылочных типов с null
        System.out.println(string1 != null);
        System.out.println(string2 == null);

        if (string2 != null) System.out.println(string2.equals("Строка"));

        // конкатенация строк
        string1 = "Java";
        string2 = "Python";

        String concatString = string1 + " :: " + string2;
        System.out.println(concatString);

        concatString = string1.concat(" :: ").concat(string2);
        System.out.println(concatString);

        for (int i = 0; i < 10; i += 1) {
            concatString += i + " ";
            concatString.concat(i + " ");
        }

        // StringBuilder - работает быстро,
        // но не используется в многопоточных программах

        // StringBuffer - работает медленнее,
        // но используется в многопоточных программах (потокобезопасный)


        StringBuilder sb = new StringBuilder();
        // fori
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
        concatString = sb.toString();

        System.out.println(concatString);
    }
}
