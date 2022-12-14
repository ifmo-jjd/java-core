package ru.itmo.lessons.lesson29.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationLesson {
    public static void main(String[] args) {
        Class<Cat> catClass = Cat.class;
        // получение ссылок на аннотации
        Annotation[] annotations = catClass.getAnnotations();
        System.out.println("ссылки на аннотации " +
                Arrays.toString(annotations));

        // проверка наличия аннотации
        if (catClass.isAnnotationPresent(Config.class)){
            System.out.println("Config");

            // получение значений параметров аннотации Config, используемой с классом Cat
            Config config = catClass.getDeclaredAnnotation(Config.class);
            System.out.println(config.configFile());
            System.out.println(config.version());
        }

        Field[] catsFields = catClass.getDeclaredFields();
        for (Field field : catsFields) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println(field.getName() + " - поле с аннотацией Required");
            }
        }

    }


}
