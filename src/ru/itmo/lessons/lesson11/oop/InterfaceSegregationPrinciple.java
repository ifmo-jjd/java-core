package ru.itmo.lessons.lesson11.oop;

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        Connection connection = new Connection();
        connection.open();
        connection.close();

        BaseUnit baseUnit = new BaseUnit(23, 66);
        BaseUnit betterCopy = baseUnit.getBetterCopy();
    }
}

interface SuperInterface {
    Object getBetterCopy();
    void close();
    void open();
}

class Connection implements SuperInterface {

    @Override
    public Object getBetterCopy() {
        // нет реализации, тк метод не нужен данному классу
        return null;
    }

    @Override
    public void close() {
        System.out.println("Реализация закрытия соединения");
    }

    @Override
    public void open() {
        System.out.println("Реализация открытия соединения");
    }
}

class BaseUnit implements SuperInterface {
    private int attack;
    private int speed;

    public BaseUnit(int attack, int speed) {
        this.attack = attack;
        this.speed = speed;
    }

    @Override
    public BaseUnit getBetterCopy() {
        return new BaseUnit(this.attack * 2, this.speed * 2);
    }

    @Override
    public void close() {
        // нет реализации, тк метод не нужен данному классу
    }

    @Override
    public void open() {
        // нет реализации, тк метод не нужен данному классу
    }
}

// В данном случае SuperInterface обязывает классы реализовывать методы, которые им не нужны,
// поэтому правильно будет создать несколько интерфейсов!!!