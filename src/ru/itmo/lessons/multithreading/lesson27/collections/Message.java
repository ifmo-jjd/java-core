package ru.itmo.lessons.multithreading.lesson27.collections;

import java.time.LocalDateTime;

public class Message {
    private final String text;
    private final LocalDateTime time;

    public Message(String text) {
        this.text = text;
        time = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
