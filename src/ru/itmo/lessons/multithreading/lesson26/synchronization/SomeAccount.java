package ru.itmo.lessons.multithreading.lesson26.synchronization;

public class SomeAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    // synchronized метод блокирует монитор объекта,
    // у которого данный метод вызывается
    public /* synchronized */ void upBalance(int count) {
        balance += count;
    }

}
