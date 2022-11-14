package ru.itmo.lessons.patterns.strategy;

public class Account {

    private Order currentOrder;

    public void setOrder(Order order) {
        this.currentOrder = order;
    }
}
