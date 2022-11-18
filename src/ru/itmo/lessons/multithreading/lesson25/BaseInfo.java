package ru.itmo.lessons.multithreading.lesson25;


import java.util.concurrent.CopyOnWriteArrayList;

public class BaseInfo {
    public static void main(String[] args) {
        // после создания процесса в ОС
        // создается основной поток,
        // начинается последовательное выполнение инструкций

        //  после создания основного потока
        //  можно запускать другие потоки,
        //  тогда инструкции процесса будут выполняться параллельно

        // одно ядро процессора может обрабатывать один поток

        // Жизненный цикл потока:
        // 1. NEW - поток создан (создан экземпляр класса Thread)
        // 2. RUNNABLE - управление потоком передается Thread Scheduler -
        // 'планировщику потоков jvm' (вызван метод start у экземпляра класса Thread)
        // 3. RUNNING - поток запущен планировщиком и начинает выполнять инструкции,
        // время запуска потока определяет сам 'планировщик потоков'
        // 4. NON-RUNNING (TIME WAITING, WAITING, BLOCKED) - поток может
        // находиться в состоянии ожидания
        // 5. TERMINATED - поток завершил работу

        // Варианты описания ИНСТРУКЦИЙ потока:
        // 1. Создать класс, который наследуется от класса Thread.
        // Инструкции, которые должен выполнять поток описываются
        // в методе public void run().
        // 2. Инструкции, которые должен выполнять поток описываются в методе
        // public void run() интерфейса Runnable.
        // Набор инструкций потока можно описать в лямбда или
        // создать отдельный класс, имплементирующий данный интерфейс.
        // 3. Воспользоваться возможностями пакета java.util.concurrent.*

        // поток представлен экземпляром класса Thread

        SomeThread thread01 = new SomeThread(); // Thread
        thread01.setName("thread01");
        thread01.setPriority(2); // приоритет - значение типа int [1, 10]

        // передача thread01 планировщику потоков (Thread Scheduler)
        thread01.start();

        thread01.someVoid();

        SomeThread thread02 = new SomeThread(); // Thread
        thread02.setPriority(9);
        thread02.start();


        SomeTask someTask01 = new SomeTask(); // инструкции Runnable
        Thread thread03 = new Thread(someTask01);
        System.out.println(thread03.getPriority());
        thread03.start();

        new Thread(()-> System.out.println("lambda Thread")).start();
    }
}