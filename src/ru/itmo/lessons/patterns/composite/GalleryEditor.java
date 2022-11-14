package ru.itmo.lessons.patterns.composite;

// может работать с одним изображением / целой галереей
// Client
public class GalleryEditor {
    private Drawable drawableBlock;

    public GalleryEditor(Drawable drawableBlock) {
        this.drawableBlock = drawableBlock;
    }

    public void show(){ // отображение галереи или изображения
        drawableBlock.draw();
    }

    public void clear(){}
}