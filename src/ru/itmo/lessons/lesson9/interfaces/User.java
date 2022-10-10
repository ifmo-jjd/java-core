package ru.itmo.lessons.lesson9.interfaces;



// класс User реализует (или имплементирует) интерфейс IUser
// класс (если он не абстрактный) обязан реализовать все
// абстрактные методы интерфейса
// класс может переопределить default методы интерфейса
// класс может реализовать более одного интерфейса
public class User implements IUser, IAuthorization {

    @Override
    public void enterInfo(String message) {
        System.out.println("Реализация default метода");
    }

    @Override
    public String getUserName() {
        return "qwerty";
    }

    @Override
    public String getToken(byte[] salt) {
        return null;
    }

    @Override
    public String getLogin() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
