package ru.itmo.lessons.lesson9.question1;

public class Parent {
    public int void1(){
        return 1;
    }

    private String void2(){
        return "";
    }

    public final boolean void3() {
        return Math.random() < .5;
    }

    protected char void4(){
        return ' ';
    }

    public static int random(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}