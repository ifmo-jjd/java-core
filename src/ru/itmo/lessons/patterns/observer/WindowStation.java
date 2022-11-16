package ru.itmo.lessons.patterns.observer;

public class WindowStation implements WindObserver{
    @Override
    public void low(double speed) {
        System.out.println("WindowStation low");
    }

    @Override
    public void medium(double speed) {
        System.out.println("WindowStation medium");
    }

    @Override
    public void high(double speed) {
        System.out.println("WindowStation high");
    }
}
