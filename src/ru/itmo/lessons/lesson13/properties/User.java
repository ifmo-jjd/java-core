package ru.itmo.lessons.lesson13.properties;

public class User<T> {
    private T id; // при компиляции T - Object
    // внутри класса у id можно вызвать только методы Object

    private String login;

    public void setId(T id){
        this.id = id;
    }

    public T getId(){
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
