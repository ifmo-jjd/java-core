package ru.itmo.lessons.multithreading.lesson26.synchronization;

import java.util.ArrayList;

public class Synchronization {
    public static void main(String[] args) {
        SomeAccount account = new SomeAccount();

        ArrayList<SomeTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            transactions.add(new SomeTransaction(account)); // создание экземпляров типа Thread
        }

        for (SomeTransaction transaction : transactions) {
            transaction.start(); // передача потоков планировщику
        }
        for (SomeTransaction transaction : transactions) {
            try {
                transaction.join(); // основной поток ожидает, когда потоки присоединятся к нему
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Account " + account.getBalance());
    }
}


