package ru.itmo.lessons.patterns.pattern02;

import java.time.LocalDateTime;

public class Letter {
    private String title;
    private String text;
    private LocalDateTime created;
    private String sender;
    private String recipient;

    public Letter() {
        created = LocalDateTime.now();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }


}