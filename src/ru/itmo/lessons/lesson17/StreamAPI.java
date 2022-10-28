package ru.itmo.lessons.lesson17;


import ru.itmo.lessons.lesson16.education.Course;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        // Stream API - работа с потоками данных - java 8

        // TODO 1: Создать поток целых чисел (-560, 312, 12, -1, 45, 0, 0, 23, -2, 221)
        //  - оставить в потоке только отрицательные элементы
        //  - выбрать 5 первых элементов
        //  - добавить к каждому элементу строку " p."
        //  - вывести каждый элемент в консоль
        Stream<Integer> integerStream01 = Stream.of(-560, 312, 12, -1, 45, 0, 0, 23, -2, 221);
        integerStream01.filter(elem -> elem < 0) // filter(Predicate<? super T> predicate) boolean test(T t)
                .limit(5)
                .map(elem -> elem + " deg.") // Function <? super T, ? extends R> mapper R apply(T t);
                .map(elem -> elem.toUpperCase())
                .forEach(elem -> System.out.println(elem)); // Consumer<? super T> action void accept(T t)

        // TODO 2: Создать поток целых чисел (-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12)
        //  - оставить в потоке только уникальные элементы
        //  - отсортировать в натуральном порядке (по возрастанию)
        //  - вывести каждый элемент в консоль
        Stream<Integer> integerStream02 = Stream.of(-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12);
        integerStream02.distinct() // -6 45 12 -77 77 6 0 12
                .sorted() // правила сортировки определены методом compareTo (Comparable интерфейс)
                .forEach(System.out::println);

        // TODO 3: anyMatch, allMatch, noneMatch
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, есть ли в потеке элемент со значением 0
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, состоит ли поток из только положительных элементов
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, что в потоке нет значений больше 10_000
        Stream<Integer> integerStream03 = Stream.of(411, 7, 90, -1000, 0, 2, 71);
        System.out.println(integerStream03.anyMatch(num -> num == 0)); // Predicate<? super T> predicate boolean test(T t)

        Stream<Integer> integerStream04 = Stream.of(411, 7, 90, -1000, 0, 2, 71);
        System.out.println(integerStream04.allMatch(num -> num > 0));

        Stream<Integer> integerStream05 = Stream.of(411, 7, 90, -1000, 0, 2, 71);
        System.out.println(integerStream05.noneMatch(num -> num > 10_000));

        String[] colors = {"white", "black", "red", "yellow", "yellowgreen"};
        // TODO 4: findFirst - взять первый | findAny - взять произвольный
        // Optional<T> - java 8, null safe container
        String color = Arrays.stream(colors).findAny().get();
        color = Arrays.stream(colors).findAny().orElse("yellow");
        boolean isPresent = Arrays.stream(colors).findAny().isPresent();
        // if (Optional.lisPresent) Optional.get

        Arrays.stream(colors)
                .skip(2)
                .filter(colorElem -> colorElem.startsWith("y")) // оставить в потоке цвета, начинающиеся на "y"
                .forEach(System.out::println);

        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(7));
        System.out.println(courses);

        // min / max
        // выбрать минимальный по стоимости курс
        Course minByPrice = courses.stream()
                .min((c1, c2) -> (int) (c1.getPrice() - c2.getPrice()))
                .orElse(Course.getInstance());
        System.out.println(minByPrice);

        // выбрать максимальный по продолжительности курс
        Course maxByDuration = courses.stream()
                .max((c1, c2) -> c1.getDuration() - c2.getDuration())
                .orElse(Course.getInstance());
        System.out.println(maxByDuration);

        // sorted()
        // sorted(Comparator c)

        // Массив из Stream
        // Course[] со стоимостью выше 20_000
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20_000)
                .toArray(Course[]::new); // ссылка на конструктор массива
        // .toArray(); -> Object[]
        System.out.println(Arrays.toString(coursesArr));

        // List<Course> продолжительность 3 и более месяца
        // увеличить стоимость каждого на 5000
        // map - Function mapper -> R apply(T t);
        // peek - Consumer action -> void accept(T t);
        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration() >= 3)
                .peek(course -> course.setPrice(course.getPrice() + 5000))
                // .map(course -> new Course(...course.getPrice() + 5000))
                .collect(Collectors.toList()); // .toList() список
        // .collect(Collectors.toSet()); // .toSet() множество
        // .collect(Collectors.toCollection(ArrayList::new)); конкретная коллекция

        // Map: ключи - элементы массива, значения - размер строки
        colors = new String[]{"white", "black", "red", "red", "yellow", "yellowgreen"};

        Map<String, Integer> map01 = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        elem -> elem, // ключи Function keyMapper
                        elem -> elem.length(), // значения Function valueMapper
                        (elemValue1, elemValue2) -> elemValue1 // как сформирать значение, если ключи одинаковые
                        // BinaryOperator<U> mergeFunction R apply(T t, U u);
                        // HashMap::new - конкретная мапа
                ));
        System.out.println(map01);

        // ключи - названия
        // значения - списки курсов
        // groupingBy - Function classifier - R apply(T t)
        Map<String, List<Course>> map02 = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName()));
        // .collect(Collectors.groupingBy(Course::getName))
        Map<Integer, ArrayList<Course>> map03 = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getDuration(),
                        Collectors.toCollection(ArrayList::new)
                ));

        // ключи - названия
        // значения - количество курсов
        Map<String, Long> map04 = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getName(),
                        Collectors.counting()
                ));

        // ключи - названия
        // значения - средняя стоимость
        Map<String, Double> map05 = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getName(),
                        Collectors.averagingDouble(course -> course.getPrice())
                ));

        // ключи - названия курсов,
        //  значения - мапа, в которой
            // ключи - продолжительность курса,
            // а значения - списки курсов с указанной в ключе продолжительностью
        Map<String, Map<Integer, List<Course>>> map06 = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.groupingBy(Course::getDuration)
                ));


    }
}
