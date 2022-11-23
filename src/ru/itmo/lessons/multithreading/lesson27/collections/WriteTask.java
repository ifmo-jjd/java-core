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
        // механизм завершения работы потока
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
                String text = strings[(int) (Math.random() * strings.length)];
                Message message = new Message(text);
                // объект добавляется в конец очереди,
                // если очередь переполнена, поток блокируется
                // до появления в очереди свободного места
                messages.put(message);
                System.out.println("write " + message);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
