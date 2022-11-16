package ru.itmo.lessons.patterns.dao;

import java.util.List;

public interface Storage<T> {
    void add(T t);
    List<T> getAll();
    T get(int id);
}
