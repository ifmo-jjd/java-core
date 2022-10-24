package ru.itmo.lessons.lesson16;

import ru.itmo.lessons.lesson16.education.Course;
import ru.itmo.lessons.lesson16.education.University;

public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

    }
}
