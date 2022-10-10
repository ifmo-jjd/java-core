package ru.itmo.lessons.lesson9.interfaces;

public interface IAuthorization {
    // интерфейс может содержать:
    // абстрактные методы
    String getToken(byte[] salt);
    String getLogin();
    String getPassword();

    // default методы с реализацией
    default void enterInfo(String message) {
        System.out.println("Авторизация прошла " + message + getLogin());
    }

    // static методы с реализацией
    static void staticVoid(){ // вызов IAuthorization.staticVoid();
        System.out.println("static void");
    }

    // статические свойства
    static String staticInfo = "static infо";

    // не может содержать обычных методов с реализацией, свойств,
    // конструкторов
}
