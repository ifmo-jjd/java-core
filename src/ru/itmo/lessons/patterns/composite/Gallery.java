package ru.itmo.lessons.patterns.composite;

// может хранить изображения и
// другие галереи с изображениями

import java.util.ArrayList;

// должна быть возможность отрисовки
// Composite
public class Gallery implements Drawable{
    private String title;
    private ArrayList<Drawable> elements;

    public Gallery() {
        elements = new ArrayList<>(20);
    }

    public void addToGallery(Drawable drawable){
        elements.add(drawable);
    }

    public void removeFromGallery(Drawable drawable){
        elements.remove(drawable);
    }

    public Gallery(String title) {
        this.title = title;
    }

    @Override
    public void draw() {
        elements.forEach(element-> element.draw());
    }
}