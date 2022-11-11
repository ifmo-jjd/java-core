package ru.itmo.lessons.patterns.factorymethod;

public class Pattern01 {
    public static void main(String[] args) {

        String filename = args[0];

        // TODO:: реализовать возможность создания объектов
        //  типа Handler в зависимости от значения filename

        Handler handler = Handler.getHandler(filename);
        handler.write("данные для записи");
        handler.read();
    }
}