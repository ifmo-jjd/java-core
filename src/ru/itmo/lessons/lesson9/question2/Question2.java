package ru.itmo.lessons.lesson9.question2;

public class Question2 {
    public static void main(String[] args) {
        Storage storage = new Storage(4);
        // элемент должен быть добавлен в массив по индексу 0
        storage.addString("1");
        // элемент должен быть добавлен в массив по индексу 1
        storage.addString("2");
        // элемент должен быть добавлен в массив по индексу 2
        storage.addString("3");
        // элемент должен быть добавлен в массив по индексу 3
        storage.addString("4");
        // элемент не должен быть добавлен в массив (нет места для '5')
        storage.addString("5");
        // элемент не должен быть добавлен в массив (нет места для '6')
        storage.addString("6");
        System.out.println(storage.toString()); // ["1", "2", "3", "4"]
    }
}