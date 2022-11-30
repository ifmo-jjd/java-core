package ru.itmo.lessons.lesson30;

public class MemoryMessage {
    public final static String TYPE;
    private String text;
    private int code;

    static {
        TYPE = "Текстовое сообщение";
        System.out.println("Класс загружен");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
