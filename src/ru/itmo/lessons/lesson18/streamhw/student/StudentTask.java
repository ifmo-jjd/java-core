package ru.itmo.lessons.lesson18.streamhw.student;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentTask {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> byGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.toCollection(ArrayList::new)));

        //  2. Найти средний возраст учеников
        double avgAge = students.stream()
                .mapToInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())
                .average().orElse(0);
        System.out.println(avgAge); // IntStream


        System.out.println(
                students.stream().collect(Collectors.averagingInt(
                        pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()))
        );

        // 3. Найти самого младшего ученика
        Student minAge = students.stream().max(Comparator.comparing(Student::getBirth)).orElse(null);
        System.out.println(minAge);

        // 4. Найти самого старшего ученика
        Student maxAge = students.stream().min(Comparator.comparing(Student::getBirth)).orElse(null);
        System.out.println(maxAge);

        //  5. Собрать учеников в группы по году рождения
        Map<Integer, List<Student>> byBirth = students.stream()
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear()));
        System.out.println(byBirth);


        //  6. Убрать учеников с одинаковыми именами,
        //  имена и дату рождения оставшихся вывести в консоль
        Collection<Student> uniqueByName = students.stream()
                .collect(Collectors.toMap(
                        Student::getName, // student -> student->getName()
                        Function.identity(), // student -> student
                        ((pupil, pupil2) -> pupil)
                )).values();
        uniqueByName.forEach(pupil -> System.out.println(pupil.getName() + ": " + pupil.getBirth()));

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        students.sort(
                // (st1, st2) -> st1.getXXX() сравнение с st2.getXXX()
                Comparator.comparing(Student::getGender) // st -> st.getGender()
                        .thenComparing(Student::getBirth) // st -> st.getBirth()
                        .thenComparing(Student::getName).reversed() // st -> st.getName()
        );
        System.out.println(students);

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        int from = 10;
        int to = 10;
        students.forEach(
                pupil -> {
                    if (LocalDate.now().getYear() - pupil.getBirth().getYear() < to
                            && LocalDate.now().getYear() - pupil.getBirth().getYear() >= from) {
                        System.out.println(pupil);
                    }
                }
        );

        // 9. Собрать в список всех учеников с именем=someName
        List<Student> pupilsByName = students.stream()
                .filter(pupil -> pupil.getName().equals("Петр")).toList();

        // 10. Собрать Map<Pupil.Gender, Integer>,
        // где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Student.Gender, Integer> genderCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.summingInt(
                                pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())));
        System.out.println(genderCount);
    }

}
