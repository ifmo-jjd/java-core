package ru.itmo.lessons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArgsAndProps {
    public static void main(String[] args) {
        // String[] args - аргументы, с которыми запускается программа
        // Запуск с аргументами (IDEA):
        // 1. ПКМ -> Modify Run Configuration или
        //    Меню - Run -> Edit Configuration
        // 2. Program Arguments: перечислить через пробел
        for (String arg: args){
            System.out.println(arg);
        }

        // import java.util.Properties;
        Properties properties = new Properties();
        // хранение данных основано на хеш таблице
        // хранят данные в паре ключ - значение
        // ключи и значения могут быть только строками
        // позволяют загружать данные из InputStream (часто из *.properties файлов)
        properties.setProperty("ключ", "значение"); // добавление
        String value = properties.getProperty("ключ"); // получение значения по ключу
        System.out.println(value);
        properties.clear(); // очистить

        // resources -> config.properties
        // загрузить данные из .properties файла в Properties объект
        try(InputStream input = ArgsAndProps.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
                properties.load(input);
        } catch (IOException e) {
            System.out.println("Проблемы с чтением config.properties");
        }
        properties.forEach((key, val)
                -> System.out.println(key + ": " + val));

    }
}
