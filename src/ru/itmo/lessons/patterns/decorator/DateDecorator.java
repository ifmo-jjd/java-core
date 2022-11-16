package ru.itmo.lessons.patterns.decorator;

import java.time.LocalDateTime;

// реализация конкретного декоратора
public class DateDecorator extends BaseDecorator{
    public DateDecorator(ILog logger) {
        super(logger);
    }

    @Override
    public void log(String data) {
        String newData = data + " date: " + LocalDateTime.now();
        super.log(newData);
    }
}