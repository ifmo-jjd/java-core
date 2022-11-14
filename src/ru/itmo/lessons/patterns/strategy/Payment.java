package ru.itmo.lessons.patterns.strategy;

public interface Payment {
    void pay(double sum);
    void cancel();
    // ...
}
