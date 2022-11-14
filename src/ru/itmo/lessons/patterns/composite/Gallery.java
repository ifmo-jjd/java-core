package ru.itmo.lessons.patterns.composite;

// может хранить изображения и
// другие галереи с изображениями

import java.util.ArrayList;

// должна быть возможность отрисовки
public class Gallery implements Drawable{
    private String title;
    private ArrayList<Drawable> elements;

    public Gallery(String title) {
        this.title = title;
    }

    @Override
    public void draw() {
    }
}