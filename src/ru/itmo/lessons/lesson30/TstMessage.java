package ru.itmo.lessons.lesson30;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class TstMessage {

    public static void main(String[] args) {
        // String[] args = []
        String data = "Срочное сообщение";
        int num = 10;

        printStart();

        MemoryMessage message = new MemoryMessage(); // сильная ссылка
        message.setText(data);
        message.setCode(num);

        // слабая ссылка
        WeakReference<MemoryMessage> weakReference = new WeakReference<>(message);
        message = null;
        // объект, у которого есть сильные ссылки не удаляется сборщиком мусора
        // объект, у которого есть только слабые ссылки удаляется сборщиком мусора,
        // если остается мало heap памяти

        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
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