package ru.itmo.lessons.patterns.pattern01;

import java.io.File;

public class JsonHandler extends Handler{

    public JsonHandler(File file) {
        super(file);
    }

    @Override
    public void read() {
        System.out.println("Чтение из json файла");
    }

    @Override
    public void write(String data) {
        System.out.println("Запись в json файл");
    }
}