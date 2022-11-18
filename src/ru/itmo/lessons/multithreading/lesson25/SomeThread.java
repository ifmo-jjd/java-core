package ru.itmo.lessons.multithreading.lesson25;

public class SomeThread extends Thread{
    // может содержать любые свойства, методы, конструкторы

    public void someVoid(){
        System.out.println(this.getName()); // SomeThread
        System.out.println(Thread.currentThread().getName()); // основной поток
    }

    @Override // от класса Thread
    public void run(){ // инструкции потока
        System.out.println(this.getName()); // SomeThread
        System.out.println(Thread.currentThread().getName()); // SomeThread
    }

}
