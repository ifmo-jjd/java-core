package ru.itmo.lessons.lesson22.inner;

// public класс верхнего уровня может быть только один в файле,
// имя файла должно совпадать с именем класса
// не public классов верхнего уровня может быть сколько угодно в файле,
// на такая структура на практике считается плохим тоном
public class User {
    private int startLevel;
    private String login;

    public User(int startLevel, String login) {
        this.startLevel = startLevel;
        this.login = login;
    }

    public int getStartLevel() {
        return startLevel;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "User{" +
                "startLevel=" + startLevel +
                ", login='" + login + '\'' +
                '}';
    }

    public class Account {
        private float balance;

        public Account(float balance) {
            // this - ссылка на экземпляр Account
            // User.this - ссылка на экземпляр User

            this.balance = balance + User.this.startLevel;
            // this.balance = balance + startLevel;
        }

        public void updateBalance(int balance) {
            this.balance += balance;
        }

        public float getBalance() {
            return balance;
        }

        public User getUser(){
            return User.this;
        }

    }
}