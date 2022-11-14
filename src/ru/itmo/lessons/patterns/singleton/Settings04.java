package ru.itmo.lessons.patterns.singleton;

import java.time.LocalDate;

public class Settings04 {
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

    // Реализация паттерна (через вложенный класс)
    // гарантирует создание одного экземпляра в одно- и многопоточных средах
    // используется ленивая инициализация
    private Settings04() {
        token = "nuny-4v3l-34cn22-m32r2";
        expire = LocalDate.now();
    }

    private static class Settings04Holder { // загрузка по требованию
        private static final Settings04 SETTINGS_04_INSTANCE = new Settings04();
    }

    public static Settings04 getSettings() {
        return Settings04Holder.SETTINGS_04_INSTANCE;
    }
}