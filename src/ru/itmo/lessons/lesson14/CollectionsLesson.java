package ru.itmo.lessons.lesson14;

import java.util.*;

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
        studentArrayList.clear(); // удаляет все элементы коллекции

        System.out.println(studentArrayList.size()); // 0


        studentArrayList.addAll(Arrays.asList(
                student1, student2, student3, student4, student5));

        for (Student student : studentsList) {
            // student - на каждой итерации ссылка на элемент коллекции
            System.out.println(student.getId());
            student.setName("Студент: " + student.getName());
            // в циклах for нельзя удалять элементы коллекций,
            // удаление приведет к ConcurrentModificationException
        }

        // удалить всех студентов старше 20 лет
        Iterator<Student> iterator = studentArrayList.iterator();
        while (iterator.hasNext()) {
            // iterator.next() - ссылка на элемент коллекции
            if (iterator.next().getAge() > 20) {
                iterator.remove(); // удаление
            }
        }

        // LinkedList: интерфейсы List, Deque (Queue) -
        // двунаправленный связный список
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления
        // нельзя задать первоначальную емкость и уменьшить емкость по размеру

        // LinkedList
        //    private Node first;
        //    private Node last;

        // class Node
        //   private Node next;
        //   private value;

        // add(student1);
        // new Node[value-student1, next-null] - #1
        // LinkedList[first-#1, last-#1]

        // add(student2);
        // Node#1 [next-#2]
        // new Node[value-student2, next-null] - #2

        //  Node(student 1) -> Node(student 2) -> Node(student, 3) -> null
        // LinkedList:
        // first -> Node(student 1)
        // last -> Node(student 3)
        // size

        // Set
        // 1. используются для хранения уникальных элементов
        // 2. обязательно дб переопределен метод equals у элементов,
        // которые добавляются в set
        // 3. нет доступа к индексам

        System.out.println("HashSet");
        // 1. основан на хеш таблице (бд быть переопределен метод
        // hashCode у элементов, которые добавляются в hashset)
        // 2. порядок хранения может отличаться от порядка добавления
        // 3. может хранить null

        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet = new HashSet<>(studentArrayList);
        System.out.println(studentHashSet);
        // size, clear, addAll, remove(объект), add(объект) и тд
        // нет методов доступа по индексу
        int age = 0;
        for (Student student : studentHashSet) {
            age += student.getAge();
        }
        System.out.println(age);

        // LinkedHashSet
        // 1. медленнее HashSet
        // 2. порядок хранения элементов соответствует порядку добавление


        // TreeSet
        // 1. добавление null приведет к ошибке
        // 2. хранит элементы в отсортированном виде
        // (используется алгоритм красно-черного бинарного дерева)

        // Для добавления элементов в TreeSet
        // 1. чтобы тип (класс), элементы которого будут храниться в TreeSet
        // реализовывал интерфейс Comparable и его метод compare
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student5);
        studentTreeSet.add(student4);
        studentTreeSet.add(student3);
        System.out.println(studentTreeSet);

        // 2. создать экземпляр класса Comparator
        Comparator<Student> comparator01 = new NameComparator();
        Comparator<Student> comparator02 = new AgeComparator();
        Comparator<Student> comparator03 =
        comparator01.thenComparing(comparator02);

        TreeSet<Student> studentTreeSet02 = new TreeSet<>(comparator03);
        studentTreeSet02.add(student5);
        studentTreeSet02.add(student4);
        studentTreeSet02.add(student3);


        Comparator<Magazine> magazineComparator01 = new TitleComparator();
        Comparator<Magazine> magazineComparator02 = new PicturesCountComparator();
        Comparator<Magazine> magazineComparator03 = new TitleComparator()
                .thenComparing(new PicturesCountComparator());

        TreeSet<Magazine> magazineTreeSet = new TreeSet<>(magazineComparator03);









    }
}
