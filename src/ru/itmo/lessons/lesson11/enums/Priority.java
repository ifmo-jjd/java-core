package ru.itmo.lessons.lesson11.enums;

// перечисление может создаваться со свойствами, конструкторами, методами
// можно не ставить ; после последнего элемента,
// если в перечислении больше ничего нет


// Priority extends Enum
// Enum -> Object
public enum Priority /* доступна имплементация интерфейсов */ {
    HIGH(10), MIDDLE(5), LOW(1); // объекты (экземпляры) Priority

    // свойства
    private int code;

    // модификатор доступа конструктора перечислений можно опустить
    Priority(int code){
        this.code = code;
    }

    // методы доступны всем объектам перечисления согласно модификаторам доступа
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



}
