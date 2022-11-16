package ru.itmo.lessons.patterns.observer;

public interface WindObserver {
    void low(double speed);
    void medium(double speed);
    void high(double speed);
}
