package ru.itmo.lessons.multithreading.lesson27.collections;

import java.util.concurrent.ArrayBlockingQueue;

// функционал потока производителя
public class WriteTask implements Runnable{
    // блокирующая очередь
   private ArrayBlockingQueue<Message> messages;

    public WriteTask(ArrayBlockingQueue<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        String[] strings = {"сообщение 1", "сообщение 2", "сообщение 3"};
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
