package ru.itmo.lessons.lesson22.anonymous;

public class Button {
    private String text;
    private String color = "white";
    private String textColor = "black";
    private Clickable action;

    public Button(String text) {
        this.text = text;
    }
    public void setAction(Clickable action) {
        this.action = action;
    }

    public Clickable getAction() {
        return action;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }


}