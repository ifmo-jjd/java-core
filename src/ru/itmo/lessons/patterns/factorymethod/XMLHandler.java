package ru.itmo.lessons.patterns.factorymethod;

import java.io.File;

public class XMLHandler extends Handler{

    public XMLHandler(File file) {
        super(file);
    }

    @Override
    public void read() {
        System.out.println("Чтение из xml файла");
    }

    @Override
    public void write(String data) {
        System.out.println("Запись в xml файл");
    }
}