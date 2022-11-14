
package ru.itmo.lessons.patterns.composite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Composite {
    public static void main(String[] args) throws IOException {
        Image image01 = new Image("images/house", "House");
        Image image02 = new Image("images/tree", "Tree");
        Image image03 = new Image("images/sun", "Sun");


        Image image04 = new Image("images/fox", "Fox");
        Image image05 = new Image("images/Wolf", "Wolf");

        Gallery gallery01 = new Gallery("Wild Animals");
        gallery01.addToGallery(image04);
        gallery01.addToGallery(image05);

        Image image06 = new Image("images/cat", "Cat");
        Image image07 = new Image("images/dog", "Dog");

        Gallery gallery02 = new Gallery("Pets");
        gallery02.addToGallery(image06);
        gallery02.addToGallery(image07);


        Gallery gallery03 = new Gallery("Village");
        gallery03.addToGallery(gallery01);
        gallery03.addToGallery(gallery02);
        gallery03.addToGallery(image01);
        gallery03.addToGallery(image02);
        gallery03.addToGallery(image03);


        GalleryEditor galleryEditor = new GalleryEditor(gallery03);
        galleryEditor.show();


    }
}