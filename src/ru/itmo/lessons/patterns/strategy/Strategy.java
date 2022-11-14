package ru.itmo.lessons.patterns.strategy;

public class Strategy {
    public static void main(String[] args) {
        Account account = new Account(new YaMoney());

        Order order01 = new Order();
        account.setOrder(order01);
        order01.setSum(100_000);

        account.payCurrentOrder();

        Order order02 = new Order();
        account.setOrder(order02);
        order02.setSum(500_000);

        account.setPaymentMethod(new VKPay());
        account.payCurrentOrder();
    }
}
