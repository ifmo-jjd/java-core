package ru.itmo.lessons.lesson11.enums;

import java.time.LocalDateTime;

public class Article {
    private String title; // null
    private String text; // null
    // created - ссылка на объект, хранящий информацию о дате и времени
    private final LocalDateTime created; // null
    private Country country; // null

    public Article(String title){
        this.title = title;
        created = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
