package ru.itmo.lessons.patterns.pattern01;

import java.io.File;

abstract public class Handler {
    protected File file;

    public Handler(File file) {
        this.file = file;
    }

    abstract public void read();
    abstract public void write(String data);
}