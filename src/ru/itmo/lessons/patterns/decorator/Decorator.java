package ru.itmo.lessons.patterns.decorator;


public class Decorator {
    public static void main(String[] args) {
        Fitness fitness = new Fitness(new ConsoleLogging());
        fitness.logInfo();

        fitness.setLogger(new DateDecorator(new ConsoleLogging()));
        fitness.logInfo();

        fitness.setLogger(new DateDecorator(new CodeDecorator(new ConsoleLogging())));
        fitness.logInfo();
    }
}