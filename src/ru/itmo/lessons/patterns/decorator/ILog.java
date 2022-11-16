package ru.itmo.lessons.patterns.decorator;

// общий тип данных для классов с основным функционалом
// и классов - декораторов
public interface ILog {
    void log(String data);
}