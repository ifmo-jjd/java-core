package ru.itmo.lessons.patterns.singleton;

import java.io.Serializable;
import java.time.LocalDate;

public class Settings01 implements Serializable {

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

    // Реализация паттерна (ленивая - lazy)
    // для однопоточных сред
    // использование в многопоточной среде может породить множество экземпляров
    private Settings01() {
        token = "nuny-4v3l-34cn22-m32r2";
        expire = LocalDate.now();
        if (SETTINGS_01_INSTANCE != null) throw new IllegalStateException("Экземпляр уже создан");
    }

    private static Settings01 SETTINGS_01_INSTANCE;

    public static Settings01 getSettings() {
        if(SETTINGS_01_INSTANCE == null) SETTINGS_01_INSTANCE = new Settings01();
        return SETTINGS_01_INSTANCE;
    }

    // для многопоточных сред
    /*
    private static volatile Settings01 SETTINGS_01_INSTANCE = null;
    public static Settings01 getSettings() {
        if (SETTINGS_01_INSTANCE == null) {
            synchronized (Settings01.class) {
                SETTINGS_01_INSTANCE = new Settings01();
            }
        }
        return SETTINGS_01_INSTANCE;
    }
    */

    // для многопоточных сред (двойная проверка на созданный экземпляр)
    /*
    private static volatile Settings01 SETTINGS_01_INSTANCE = null;
    public static Settings01 getSettings() {
        if (SETTINGS_01_INSTANCE == null) {
            synchronized (Settings01.class) {
                if (SETTINGS_01_INSTANCE == null) {
                    SETTINGS_01_INSTANCE = new Settings01();
                }
            }
        }
        return SETTINGS_01_INSTANCE;
    }
    */

    @Override
    protected Object clone() {
        throw new IllegalStateException("Клонирование не поддерживается");
    }

    protected Object readResolve(){
        return SETTINGS_01_INSTANCE;
    }
}