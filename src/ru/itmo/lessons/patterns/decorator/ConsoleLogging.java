package ru.itmo.lessons.patterns.decorator;

// класс с основным функционалом
public class ConsoleLogging implements ILog {
    @Override
    public void log(String data) {
        System.out.println(data);
    }
}