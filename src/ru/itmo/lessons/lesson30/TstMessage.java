package ru.itmo.lessons.lesson30;

public class TstMessage {

    public static void main(String[] args) {
        String data = "Срочное сообщение";
        int num = 10;

        printStart();

        MemoryMessage message = new MemoryMessage();
        message.setText(data);
        message.setCode(num);
    }

    private static void printStart(){
        System.out.println("START");
        // объект типа Message создается в heap памяти
        MemoryMessage message = new MemoryMessage();
        // еще один объект типа Message создается в heap памяти
        message = new MemoryMessage();
        // обнуление ссылки (не удаление объекта)
        message = null;
    }
}