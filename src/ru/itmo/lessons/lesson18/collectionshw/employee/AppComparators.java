package ru.itmo.lessons.lesson18.collectionshw.employee;

import java.util.Comparator;

public class AppComparators {
    public final static Comparator<Employee> BY_NAME = (Employee o1, Employee o2) ->
            o1.getName().compareTo(o2.getName());
    public final static Comparator<Employee> BY_AGE = (Employee o1, Employee o2) ->
            o1.getAge() - o2.getAge();
}
