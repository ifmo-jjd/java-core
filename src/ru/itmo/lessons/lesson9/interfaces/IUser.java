package ru.itmo.lessons.lesson9.interfaces;

public interface IUser {
    // default методы с реализацией
    default void enterInfo(String message) {
        System.out.println("Авторизаванные пользователь. " + message);
    }

    String getUserName();
}
