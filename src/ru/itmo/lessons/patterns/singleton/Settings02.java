package ru.itmo.lessons.patterns.singleton;

import java.time.LocalDate;

public class Settings02 {
    private String token;
    private LocalDate expire;

    public String getToken() {
        return token;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setToken(String token) {
        this.token = token;
        expire = LocalDate.now();
    }

    // Реализация паттерна (по умолчанию - eager)
    // создание объекта происходит по умолчанию, а не по требованию
    private static volatile Settings02 SETTINGS_02_INSTANCE = new Settings02();


    private Settings02() {
        token = "nuny-4v3l-34cn22-m32r2";
        expire = LocalDate.now();
    }

    public static Settings02 getSettings() {
        return SETTINGS_02_INSTANCE;
    }
}