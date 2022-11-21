package ru.itmo.lessons.multithreading.lesson26.synchronization;

public class DeadLock {
    public static void main(String[] args) {

        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " start");

            synchronized (object1){
                try {
                    System.out.println("thread1 -> object2");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("thread1 -> object2 + object1");
                }
            }
        });

        Thread thread2 = new Thread(()->{

            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (object2){
                try {
                    System.out.println("thread2 -> object1");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("thread2 -> object2 + object1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}