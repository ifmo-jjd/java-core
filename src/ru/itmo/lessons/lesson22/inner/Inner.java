package ru.itmo.lessons.lesson22.inner;

public class Inner {
    public static void main(String[] args) {
        User user = new User(10, "qwe");

        // экземпляр внутреннего класса
        User.Account account = user.new Account(20);
        account.updateBalance(1000);
        System.out.println(account.getUser().getLogin());
        System.out.println(account.getUser().getStartLevel());
        System.out.println(account.getBalance());

        // экземпляр внутреннего класса
        User.Account account2 = new User(0, "asd").new Account(200);

        System.out.println(account2.getUser());
    }
}