package ru.itmo.lessons.patterns.dao;

import java.util.List;

// Data Access Object (DAO)
public class ItemFileStorage implements Storage<Item> {
    public Item getByTitle(String title){
        return null;
    }

    @Override
    public void add(Item item) {}

    @Override
    public List<Item> getAll() {
        return null;
    }

    @Override
    public Item get(int id) {
        return null;
    }
}
