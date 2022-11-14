package ru.itmo.lessons.patterns.strategy;

public class VKPay implements Payment{
    @Override
    public void pay(double sum) {
        System.out.println("VKPay оплата " + sum);
    }

    @Override
    public void cancel() {

    }
}
