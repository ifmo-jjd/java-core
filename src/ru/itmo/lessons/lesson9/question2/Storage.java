package ru.itmo.lessons.lesson9.question2;

import java.util.Arrays;
import java.util.Objects;

public class Storage {
    private String[] strings;

    public Storage(int len) {
        if (len < 1) {
            throw new IllegalArgumentException("Задайте размер массива");
        }
        strings = new String[len];
    }

    public Storage(String[] strings) {
        /*
        if (strings == null) {
            throw new IllegalArgumentException("В конструктор необходимо передать массив");
        }
        this.strings = strings;
        */
        this.strings = Objects.requireNonNull(strings, "В конструктор необходимо передать массив");
    }

    public void addString(String newString) {
        // Добавление в маасив strings без цикла?
    }

    public /*void*/ int getStringsCount(){
        int count = 0;
        for (String string : strings) {
            if (string != null) count++;
        }
        // System.out.println(count);
        return count;
    }

    public void /*getStrings*/ printStrings(){
        System.out.println(Arrays.toString(strings));
    }

    @Override
    public String toString() {
        return "Storage{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}