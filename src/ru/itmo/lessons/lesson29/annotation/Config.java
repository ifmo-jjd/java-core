package ru.itmo.lessons.lesson29.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    // параметры аннотации: строки, примитивы и перечисления
    // обязательный параметр,
    // должен быть указан при использовании аннотации
    String configFile();
    // параметр со значением по умолчанию, можно не указывать
    // при использовании аннотации
    long version() default 1;
}

