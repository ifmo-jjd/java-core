package ru.itmo.lessons.patterns.singleton;

import java.time.LocalDate;

public enum Settings03 {

    SETTINGS_03_INSTANCE;

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


    // Реализация паттерна (через перечисление)
    // enum гарантирует создание одного экземпляра в одно- и многопоточных средах
    // ленивая инициализация невозможна
    Settings03() {
        token = "nuny-4v3l-34cn22-m32r2";
        expire = LocalDate.now();
    }

    public static Settings03 getSettings() {
        return SETTINGS_03_INSTANCE;
    }

}