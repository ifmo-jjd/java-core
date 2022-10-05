package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.units.King;

// ru.itmo.lessons.lesson7.Application
public class Application {
    public static void main(String[] args) {
        King king01 = new King(2000);
        king01.rest();

        King king02 = new King(2000);
        king02.rest(king01);

        System.out.println(king01.getHealthScore());
    }
}
