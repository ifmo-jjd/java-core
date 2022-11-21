package ru.itmo.lessons.multithreading.lesson26.synchronization;

public class SomeTransaction extends Thread{
    private SomeAccount account;

    public SomeTransaction(SomeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        // synchronized блок - блокирует монитор объекта из ()
        // монитор будет разблокирован, когда все инструкции
        // из synchronized блока будут выполнены

        // synchronized блоков может быть несколько,
        // их можно вкладывать друг в друга

        // операции, которые не связаны с изменением свойств блокируемого объекта
        // (в данном случае account) не должны вкладываться в synchronized блок
        synchronized (account) {
            account.upBalance(10);
        }

    }
}
