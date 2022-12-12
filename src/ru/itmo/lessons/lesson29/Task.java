package ru.itmo.lessons.lesson29;

import ru.itmo.lessons.lesson29.annotation.Cat;
import ru.itmo.lessons.lesson29.annotation.Config;
import ru.itmo.lessons.lesson29.annotation.Required;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Properties;

public class Task {

    public static void main(String[] args) {
        try {
            toString(getInstance(Cat.class));
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | IOException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    public static void toString(Object obj){
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> cls = obj.getClass();

        if (isSimple(cls)) {
            System.out.println(obj);
            return;
        }

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            // java.lang.reflect.Array для работы с массивами
            /*
            int len = Array.getLength(field.get(obj));
            for (int i = 0; i < len; i++) {
                Array.get(field.get(obj), i);
            }
            */
            if (field.getType().isArray()) continue;

            if (isSimple(field.getType())) {
                try {
                    System.out.println(field.getName() + ": " + field.get(obj));
                } catch (IllegalAccessException e) {
                    System.out.println();
                }
            } else {
                try {
                    toString(field.get(obj));
                } catch (IllegalAccessException e) {
                    System.out.println();
                }
            }
        }

    }

    public static boolean isSimple(Class<?> type) {
        return type.isPrimitive() ||
                type.isEnum() ||
                type == String.class ||
                type == Byte.class ||
                type == Short.class ||
                type == Integer.class ||
                type == Long.class ||
                type == Float.class ||
                type == Double.class ||
                type == Boolean.class ||
                type == Character.class;
    }


    public static Object getInstance(Class<?> cls) throws
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            InvocationTargetException {

        if (!cls.isAnnotationPresent(Config.class)) return null;
        Config classConfig = cls.getDeclaredAnnotation(Config.class);

        String propFile = classConfig.configFile();

        Constructor<?> constructor = cls.getDeclaredConstructor();
        Object object = constructor.newInstance();
        // Object obj = new Cat();

        Properties properties = new Properties();
        try (InputStream input = Task.class
                .getClassLoader()
                .getResourceAsStream(propFile)){
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // properties {"name"="Tom", "age"="1"}

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Required.class)) continue;
            // установить возможность работы с не public полями, установить значение
            // установить значение через сеттеры
            // 1. наличие сеттеров обязательно
            // 2. правила формирования названий сеттеров
            //    name -> setName(String name)
            //    name -> name(String name)

            String setterName = "set" + field.getName().substring(0,1).toUpperCase() +
                    field.getName().substring(1); // setName(String name)
            Method setter = cls.getDeclaredMethod(setterName, field.getType());

            String propValue = properties.getProperty(field.getName()); // Tom

            Object fieldValue = propValue;

            if (field.getType() == int.class || field.getType() == Integer.class) {
                fieldValue = Integer.valueOf(propValue);
            }

            setter.invoke(object, fieldValue);
        }

        return object;
    }

}


