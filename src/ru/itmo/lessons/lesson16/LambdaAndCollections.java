package ru.itmo.lessons.lesson16;

import ru.itmo.lessons.lesson16.education.Course;
import ru.itmo.lessons.lesson16.education.University;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        // перебор коллекции - метод foreach
        // Consumer<T> - void accept(T t);
        Consumer<Course> soutCourse = course -> System.out.println(course);
        university.getCourses().forEach(soutCourse);
        university.getCourses().forEach(course -> System.out.println(course));

        // 1) увеличить стоимость каждого курса на 10 %
        university.getCourses().forEach(
                course -> course.setPrice(course.getPrice() * 1.1));

        // 2) вывести в консоль название курсов,
        // продолжительностью меньше 3 месяцев

        Consumer<Course> courses = course -> {
            int duration = 3;
            if (course.getDuration() < duration) {
                System.out.println(course.getName());
            }
        };
        university.getCourses().forEach(courses);

        // Predicate<T> boolean test(T t);
        // 1. true, если курс дешевле 20_000
        Predicate<Course> byPrice = course -> course.getPrice() < 20_000;
        // 2. true, если продолжительность курса 3 месяца и меньше
        Predicate<Course> byDuration = course -> course.getDuration() <= 3;
        // 3. true, если название курса "jjd" без учета регистра
        Predicate<Course> byName = course ->
                course.getName().equalsIgnoreCase("jjd");

        university.getFilteredCourses(byPrice)
                .forEach(course -> System.out.println(course));

        university.getFilteredCourses(byPrice.and(byDuration.or(byName)))
                .forEach(course -> System.out.println(course));

        university.getFilteredCourses(byPrice.and(byDuration).and(byName))
                .forEach(course -> System.out.println(course));

        // удаление методом removeIf
        // Predicate<T> boolean test(T t);
        university.getCourses().removeIf(course -> course.getPrice() < 15_000);
        university.getCourses().forEach(course -> System.out.println(course));

        // сортировка (Comparator)
        // Comparator - int compare(T o1, T o2);
        Comparator<Course> comparingByName = (course01, course02) ->
                course01.getName().compareTo(course02.getName());

        Comparator<Course> comparingByPrice = (course01, course02) ->
                (int) (course01.getPrice() - course02.getPrice());

        // university.getCourses().sort(comparingByName);
        university.getCourses()
                .sort(comparingByName.thenComparing(comparingByPrice));
        System.out.println(university.getCourses());
    }
}
