package ru.itmo.lessons.multithreading.lesson27.executors;

import ru.itmo.lessons.multithreading.lesson27.collections.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CallableAndFuture {
    public static void main(String[] args) {

        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        // Callable - задачи, которые будут выполнять потоки из пула
        Callable<Message> task = new MessageGenerator();

        ArrayList<Future<Message>> taskResults = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // добавляем задачу в очередь на выполнение
            // сообщаем, куда нужно передать результат работы потока
            // Future - контейнер, с результатом работы одного потока
            Future<Message> resultContainer = pool1.submit(task);
            taskResults.add(resultContainer);
            // void execute(Runnable command);
            // <T> Future<T> submit(Callable<T> task)
        }

        // t1, t2
        // общая коллекция, куда t1, t2 передают данные[]

        // main поток ждет, когда t1, t2 закончат - join
        // после чего может извлекать данные из общей коллекции

        // Future[message]  -> task
        // Future[message].get() -> message
        // Future[null].get(время ожидания результата)

        /*for (Future<Message> taskResult : taskResults) {
            System.out.println("Ожидание получения данных");
            try {
                System.out.println("Сообщение из контейнера: " + taskResult.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool1.shutdown();*/

        for (Future<Message> taskResult : taskResults) {
            System.out.println("Ожидание получения данных");
            try {
                System.out.println("Сообщение из контейнера: " +
                        taskResult.get((long) (Math.random() * 2000), TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Не смог дождаться результата");
            }
        }
        pool1.shutdown();

        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        List<Callable<Message>> tasksList = new ArrayList<>();
        tasksList.add(new MessageGenerator());
        tasksList.add(new MessageGenerator());
        tasksList.add(new MessageGenerator());

        // список задач [t1, t2, t3]
        // список Future [c1, c2, c3]
        try {
            List<Future<Message>> resultsContainer = pool2.invokeAll(tasksList);
            pool2.shutdown();
            for (Future<Message> container : resultsContainer) {
                System.out.println("Сообщение " + container.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // задачу можно отменить future.cancel(true);
        // можно проверить, отменена ли задача future.isCanceled();
        // можно проверить, выполнена ли задача future.isDone();



    }
}