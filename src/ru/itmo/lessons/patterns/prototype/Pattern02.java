package ru.itmo.lessons.patterns.prototype;

public class Pattern02 {
    public static void main(String[] args) {
        Letter letter = new Letter();
        letter.setTitle("Важное письмо");
        letter.setText("...");
        letter.setSender("Отдел 1453");
        letter.setRecipient("Отдел 39");

        // TODO:: реализовать возможность создания копий писем.
        //  При копировании должна устанавливаться текущая дата
    }
}
