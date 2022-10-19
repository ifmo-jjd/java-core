package ru.itmo.lessons.lesson13.properties;

public class PropertiesApp {
    public static void main(String[] args) {
        User user = new User();
        user.setLogin("qwerty");
        user.setId("user01");
        Object id = user.getId();
        // System.out.println(id.только методы Object);

        User<String> stringUser = new User<>();
        stringUser.setLogin("asd");
        stringUser.setId("user02");
        String stringId = stringUser.getId();
        // System.out.println(stringId.методы строк);
        System.out.println(stringId.startsWith("user"));

        User<Integer> integerUser = new User<>();
        integerUser.setLogin("zxc");
        integerUser.setId(1);
        int intId = integerUser.getId();
        System.out.println(intId > 0);

        // PairContainer<T, K> key, value
        PairContainer<String, Integer> container01 =
                new PairContainer<>("A", 1);
        System.out.println(container01.getKey()); // String
        System.out.println(container01.getValue()); // Integer

        PairContainer<String, User> container02 =
                new PairContainer<>("x", stringUser);
        Object oId = container02.getValue().getId();

        PairContainer<String, User<String>> container03 =
                new PairContainer<>("x", stringUser);
        String sId = container03.getValue().getId();
        System.out.println(sId.toUpperCase());

        // PairContainer, где ключ - Integer,
        // значение - PairContainer, где ключ - Integer,
        //            значение - User с id - String

        PairContainer<Integer, PairContainer<Integer, User<String>>> container04 =
                new PairContainer<>(1, new PairContainer<>(12, stringUser));
        System.out.println(container04.getValue().getValue().getId().toUpperCase());


    }
}
