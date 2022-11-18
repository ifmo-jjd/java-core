package ru.itmo.lessons.multithreading.lesson25;

public class SomeTask implements Runnable{
    // может содержать любые свойства, методы, конструкторы

    @Override
    public void run() { // инструкции для потока
        System.out.println("run SomeTask");
    }
}
