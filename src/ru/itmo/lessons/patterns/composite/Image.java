package ru.itmo.lessons.patterns.composite;

// единичное изображение
// должна быть возможность отрисовки
public class Image implements Drawable{
    private String path;
    private String title;

    public Image(String path, String title) {
        this.path = path;
        this.title = title;
    }

    @Override
    public void draw() {}
}
