package ru.itmo.lessons.patterns.decorator;

import java.util.UUID;


// реализация конкретного декоратора
public class CodeDecorator extends BaseDecorator{
    public CodeDecorator(ILog logger) {
        super(logger);
    }

    @Override
    public void log(String data) {
        String newData = data + " " + UUID.randomUUID();
        super.log(newData);
    }
}