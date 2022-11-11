package ru.itmo.lessons.lesson22.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Street {

    private String name;
    private String description;

    public Street(String name) {
        setName(name);
    }

    private void setName(String streetName){

        class NameValidator {
            public static final String rule = "Название улицы должно быть в списке доступных улиц и состоять минимум из 2 символов";
            private String description = "Проверка названия улицы";

            private List<String> getNamesList(){
                return new ArrayList<>(Arrays.asList("Ленина", "Чайковского", "Цветочная", "Лунная"));
            }

            private boolean isValid(){
                return streetName != null && streetName.length() >= 2 && getNamesList().contains(streetName);
            }

            /* private void getValuesExample(){
                System.out.println(this); // ссылка на экземпляр NameValidator
                System.out.println(Street.this); // ссылка на экземпляр Street
                System.out.println(name); // значение свойства name из класса Street
                System.out.println(description); // значение свойства description из класса NameValidator,
                // свойство description, объявленное в локальном классе (NameValidator)
                // оттеняет свойство description, объявленное во внешнем классе (Street)
                System.out.println(Street.this.description); // значение свойства description из класса Street
            } */
        }


        if (!new NameValidator().isValid()) {
            throw new IllegalArgumentException(NameValidator.rule);
        }

        this.name = streetName;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}