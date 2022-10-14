package ru.itmo.lessons.lesson11.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article article01 = new Article("Путешествие по Австралии");
        article01.setCountry(Country.AUSTRALIA);
        System.out.println(article01.getCountry());

        Article article02 = new Article("Путешествие по Британии");
        article02.setCountry(Country.UK);
        System.out.println(article02.getCountry());

        Country uk = Country.UK;

        System.out.println(uk == article02.getCountry()); // true,
        // т.к. uk и свойство country объекта article02 - ссылки на один объект

        // методы перечислений

        // получение массива констант
        Country[] countries = Country.values();
        // [AUSTRALIA, UK, FRANCE]
        System.out.println(Arrays.toString(countries));

        // индекс элемента перечисления в массиве
        System.out.println(Country.FRANCE.ordinal()); // 2

        for (Country country : countries) {
            System.out.println("country: " + country.name());
        }

        // принимает на вход строку,
        // возвращает ссылку на элемент перечисления
        // генерирует IllegalArgumentException, если элемент не был найден
        Country france = Country.valueOf("FRANCE");
        System.out.println(france.ordinal());

        Priority low = Priority.LOW;
        System.out.println(low.getCode()); // 1

        low.setCode(2);
        System.out.println(Priority.LOW.getCode()); // 2

        Priority[] priorities = Priority.values();
        for (Priority priority : priorities) {
            System.out.println(priority.getCode());
        }

        // по умолчанию методы toString и name возвращают одинаковые значения
        // но метод toString можно переопределить, а name нельзя
        // equals, hashCode, clone переопределить нельзя
        System.out.println(Priority.HIGH.toString());
        System.out.println(Priority.HIGH.name());

        System.out.println(Operation.MULTI.action(2, 3));
        System.out.println(Operation.SUM.action(2, 3));

    }
}
