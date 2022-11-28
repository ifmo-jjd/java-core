package ru.itmo.lessons.lesson29.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// объявление аннотации
// Required можно использовать только со свойствами класса
@Target(ElementType.FIELD)
// @Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME) // аннотация времени выполнения
public @interface Required {
}
