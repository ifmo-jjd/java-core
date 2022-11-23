package ru.itmo.lessons.multithreading.lesson27.collections;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {
    public static void main(String[] args) {
        ArrayBlockingQueue<Message> messages =
                new ArrayBlockingQueue<>(10);
        // при создании экземпляра необходимо указать максимальное
        // количество элементов
        // public ArrayBlockingQueue(int capacity, boolean fair)
        // fair - флаг справедливости

        new Thread(new WriteTask(messages)).start();
        new Thread(new WriteTask(messages)).start();
        new Thread(new WriteTask(messages)).start();
        new Thread(new ReadTask(messages)).start();


        LinkedBlockingQueue<String> strings =
                new LinkedBlockingQueue<>();


        // Vector, HashTable, Stack - synchronized

        ArrayList<String> stringArrayList = new ArrayList<>();
        List<String> list = Collections.synchronizedList(stringArrayList);
        // Collections.synchronizedSet,
        // Collections.synchronizedMap

        // блокирующая очередь DelayQueue:
        // 1. класс, экземпляры которого помещаются в очередь
        // должен имплементировать интерфейс Delayed
        // 2. take блокирует поток, если данных в очереди нет
        // или если элемент нельзя извлечь из очереди
        DelayQueue<Task> tasks = new DelayQueue<>();
        // метод put вызывает метод compareTo объекта task,
        // чтобы разместить элементы в отсортированном порядке
        tasks.put(new Task(()->{
            System.out.println("old task");
        }, LocalDateTime.now().minusDays(1)));

        tasks.put(new Task(()->{
            System.out.println("future task");
        }, LocalDateTime.now().plusMinutes(3)));

        tasks.put(new Task(()->{
            System.out.println("now task");
        }, LocalDateTime.now().plusSeconds(20)));

        while (true) {
            try { // метод take вызывает метод getDelay объекта Task,
                // и если метод вернет положительное число,
                // то поток (в данном случае main) блокируется
                Runnable runnable = tasks.take().getAction();
                new Thread(runnable).start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
