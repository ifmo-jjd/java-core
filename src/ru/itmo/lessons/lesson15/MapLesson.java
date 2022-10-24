package ru.itmo.lessons.lesson15;

import java.util.*;

public class MapLesson {

    public static void main(String[] args) {

        // HashMap
        // String - тип данных ключей
        // Integer - тип данных значений
        HashMap<String, Integer> hashMap = new HashMap<>();

        // добавление элементов
        hashMap.put("Москва", 790);
        hashMap.put("Ростов", 240);
        hashMap.put("Великий Новгород", 20);
        hashMap.put(null, null);
        // hashMap.putAll();

        // удаление пары
        hashMap.remove(null); // по ключу
        hashMap.remove("Ростов", 240); // по ключу и значению
        hashMap.remove("Москва", 240); // по ключу и значению

        // замена
        hashMap.replace("Москва", 800); // значение по ключу
        hashMap.replace("Великий Новгород", 20, 18); // значение по ключу и значению

        System.out.println(hashMap);

        // получение значений по ключу (не удаление)
        // если ключ не найден, вернет null
        System.out.println(hashMap.get("Москва")); // 800
        System.out.println(hashMap.get("Ростов")); // null

        // если ключ не найден, вернет значение по умолчанию
        System.out.println(hashMap.getOrDefault("Москва", 100)); // 800
        System.out.println(hashMap.getOrDefault("Ростов", 0)); // 0

        // проверить, содержится ли ключ в мапе
        System.out.println(hashMap.containsKey("Санкт-Петербург")); // false
        // проверить, содержится ли значение в мапе
        System.out.println(hashMap.containsValue(800)); // true

        // перебор в цикле
        // мапа.keySet(); только ключи (Set<ТипКлюча>)
        // мапа.values(); только значения (Collection<ТипЗначения>)
        // мапа.entrySet(); ключи и значения (Set<Map.Entry<ТипКлюча, ТипЗначения>>)

        for (Map.Entry<String, Integer> pair: hashMap.entrySet()) {
            System.out.println("Город (ключ): " + pair.getKey());
            System.out.println("Количество... (значение): " + pair.getValue());
        }


        // EnumMap - в качестве ключей используются перечисления (enum)
        // Role - тип данных ключей
        // String - тип данных значений
        // Role.class - ссылка на класс перечисления
        EnumMap<Role, String> enumMap01 = new EnumMap<>(Role.class);
        // values: [null, null]
        enumMap01.put(Role.USER, "Пользователь");
        // Role.USER.ordinal(); -> 0
        // values[Role.USER.ordinal()] = "Пользователь"
        // values: ["Пользователь", null]
        enumMap01.put(Role.ADMIN, "Администратор");
        // Role.ADMIN.ordinal(); -> 1
        // values[Role.ADMIN.ordinal()] = "Администратор"
        // values: ["Пользователь", "Администратор"]
        System.out.println(enumMap01.get(Role.USER)); // "Пользователь"
        // values[Role.USER.ordinal()] -> "Пользователь"


        User user1 = new User("a", "a1", Role.ADMIN, 18);
        User user2 = new User("b", "b1", Role.USER, 22);
        User user3 = new User("c", "c1", Role.USER, 22);
        User user4 = new User("d", "d1", Role.USER, 44);
        User user5 = new User("f", "f1", Role.ADMIN, 18);

        // ключи - логины, значения - пользователи
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(user1.getLogin(), user1);
        userHashMap.put(user2.getLogin(), user2);
        userHashMap.put(user3.getLogin(), user3);
        userHashMap.put(user4.getLogin(), user4);
        userHashMap.put(user5.getLogin(), user5);

        // 1. Логины пользователей старше 20 лет собрать в коллекцию
        HashSet<String> logins = new HashSet<>();
        for (Map.Entry<String, User> pair : userHashMap.entrySet()) {
            if (pair.getValue().getAge() > 20) logins.add(pair.getKey());
        }

        // 2. На основе существующей мапы создать новую,
        // где ключи - возраст пользователей
        // значения - списки пользователей соответствующего возраста
        HashMap<Integer, ArrayList<User>> ageMap = new HashMap<>();
        for (User user: userHashMap.values()) {
            if (!ageMap.containsKey(user.getAge())) {
                ArrayList<User> users = new ArrayList<>();
                users.add(user);
                ageMap.put(user.getAge(), users);
            } else {
                ageMap.get(user.getAge()).add(user);
            }
        }
        System.out.println(ageMap);




        EnumMap<Role, ArrayList<User>> enumMap02 = new EnumMap<>(Role.class);
        ArrayList<User> users = new ArrayList<>(Arrays.asList(user2, user3, user4));
        ArrayList<User> admins = new ArrayList<>();
        admins.add(user1);
        admins.add(user5);

        enumMap02.put(Role.ADMIN, admins);
        enumMap02.put(Role.USER, users);

        User user6 = new User("z", "z1", Role.USER, 39);
        // добавить пользователь в правильный список мапы

        Role role = user6.getRole(); // Role.ADMIN - Role.USER
        ArrayList<User> list = enumMap02.get(role);
        list.add(user6);
        // можно записать в одну строчку
        // enumMap02.get(user6.getRole()).add(user6);




    }
}