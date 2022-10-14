package ru.itmo.lessons.lesson11.oop;

import java.util.Arrays;

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        User user = new User();
        user.setId(2);
        user.setLogin("qwe");
        user.setPassword("dfef23dqa");

        Storage storage = new Storage();
        storage.saveUser(user);
        System.out.println(Arrays.toString(storage.getAllUsers()));
    }
}

class User {
    private long id;
    private String login;
    private String password;
    private User[] storage = new User[40];

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // следующие методы вместе со свойством storage нарушают принцип SingleResponsibilityPrinciple,
    // ответственность класса User хранить данные о пользователе,
    // он не должен заниматься их сохранением, получением и тп
    // Данный функционал правильно вынести в отдельный класс
    public User[] getAllUsers(){
        return storage;
    }
    public void saveUser(User user) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) storage[i] = user;
        }
    }
}
// ответственность класса Storage - сохранение, получение и тп пользователей
class Storage {
    private User[] storage = new User[40];
    public User[] getAllUsers(){
        return storage;
    }
    public void saveUser(User user) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = user;
                return;
            }
        }
    }
}