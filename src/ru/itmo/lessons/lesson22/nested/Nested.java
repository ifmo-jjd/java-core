package ru.itmo.lessons.lesson22.nested;

public class Nested {
    public static void main(String[] args) {

        Exam exam01 = new Exam(Exam.Subject.MATHS);

        Exam.Mark mark01 = new Exam.Mark(20);
        mark01.setDescription("Ученик набрал 20 баллов, тк правильно ответил на 20 вопросов из 70.");

        exam01.setMark(mark01);

        System.out.println(exam01.getMark().getValue());
        System.out.println(exam01.getMark().getDescription());

    }
}