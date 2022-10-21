package ru.itmo.lessons.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsLesson {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Maxim", 17);
        Student student2 = new Student(2, "Anna", 21);
        Student student3 = new Student(3, "Paul", 23);
        Student student4 = new Student(4, "Helen", 19);
        Student student5 = new Student(4, "Helen", 19);

        // 1. многопоточное или однопоточное приложение
        // 2. возможность хранить дублирующиеся элементы
        // 3. возможность хранить элементы в порядке добавления
        // 4. возможность хранить элементы в отсортированном виде

        System.out.println("ArrayList");
        // реализован на основе массива
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList = new ArrayList<>(30);

        // количество элементов коллекции
        System.out.println(studentArrayList.size()); // 0

        // добавление элементов
        studentArrayList.add(student1); // 0
        studentArrayList.add(student2); // 1
        // [student1, student2
        studentArrayList.add(1, student3); // не замена элемента по индексу
        // [student1, student3, student2

        // обращение к несуществующему индексу списка приведет к IndexOutOfBoundsException
        System.out.println(studentArrayList.size()); // 3
        // индексы 0, 1, 2
        // studentArrayList.add(10, student1); // IndexOutOfBoundsException
        // ёмкость - 30, размер - 3
        studentArrayList.trimToSize(); // ёмкость - 3, размер - 3

        // получение элементов по индексу
        System.out.println(studentArrayList.get(1));

        // удаление
        // удаление по индексу, возвращает ссылку на удаленный элемент
        Student remove = studentArrayList.remove(2);
        System.out.println(remove);

        // удаление, возвращает true / false, удаляет первый найденный объект
        // для сравнения использует метод equals
        boolean result = studentArrayList.remove(student4);
        System.out.println(result);

        Student[] students = {student1, student4};

        List<Student> studentsList = Arrays.asList(students); // список из массива

        studentArrayList.removeAll(studentsList);

        studentArrayList.addAll(studentsList);

        studentArrayList.clear(); // удаляет все элементы коллекции
        System.out.println(studentArrayList.size()); // 0




    }
}
