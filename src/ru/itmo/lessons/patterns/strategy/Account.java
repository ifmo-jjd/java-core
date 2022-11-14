package ru.itmo.lessons.patterns.strategy;

public class Account {
    private Order currentOrder;
    private Payment paymentMethod;

    public Account(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setOrder(Order order) {
        this.currentOrder = order;
    }

    public void payCurrentOrder(){
        paymentMethod.pay(currentOrder.getSum());
    }
}
