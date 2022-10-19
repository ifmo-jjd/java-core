package ru.itmo.lessons.lesson13.properties;

public class PairContainer<T, K> {
    private T key;
    private K value;
    // при компиляции T и K - Object
    // внутри класса у key и value можно вызвать только методы Object

    public PairContainer(T key, K value){
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public K getValue() {
        return value;
    }
}
