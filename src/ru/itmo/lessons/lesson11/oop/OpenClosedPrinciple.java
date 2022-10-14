package ru.itmo.lessons.lesson11.oop;

import java.util.Scanner;

public class OpenClosedPrinciple {
    public static void main(String[] args) {

        IPay payWay;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите способ оплаты: 'ya' или 'sb'");
        String userAnswer = scanner.nextLine();
        if ("ya".equalsIgnoreCase(userAnswer)) {
            payWay = new YaPay();
        } else if ("sb".equalsIgnoreCase(userAnswer)) {
            payWay = new SbPay();
        } else {
            System.out.println("Платеж не может быть проведен");
            return;
        }

        System.out.println("Введите сумму");
        double money = scanner.nextDouble();
        payWay.pay(money);
    }
}

interface IPay {
    boolean pay(double money);
}

class YaPay implements IPay{

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата ya pay: " + money);
        return true;
    }

}

class SbPay implements IPay {

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата sb pay: " + money);
        return true;
    }
}

// при необходимость работы с другими типами платежных шлюзов
// правильно добавить новый функционал в программу, не меняя код уже существующих классов