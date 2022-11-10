package ru.itmo.lessons.lesson22.local;

public class Local {
    public static void main(String[] args) {

        Street street = new Street("Ленина");
        street.setDescription("улица в Петроградском районе Санкт-Петербурга. Проходит от Сытнинской улицы " +
                "до Левашовского проспекта. Знаменита доходными домами в стилях модерна и эклектики.");

        System.out.println("Улица " + street.getName().toUpperCase() +
                " - " + street.getDescription());

    }
}