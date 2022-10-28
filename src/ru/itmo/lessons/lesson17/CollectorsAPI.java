package ru.itmo.lessons.lesson17;

import ru.itmo.lessons.lesson16.education.Course;

import java.util.ArrayList;

public class CollectorsAPI {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(20));
        // TODO 1: Создать мапу,
        //  где ключи - названия курсов,
        //  значения - списки курсов с указанным в ключе названием


        // TODO 2: Создать мапу,
        //  где ключи - продолжительность курсов,
        //  значения - списки курсов с указанной в ключе продолжительностью


        // TODO 3: Создать мапу, где ключи - названия курсов,
        //  значения - количество курсов с указанным в ключе названием


        // TODO 4: Создать мапу, где ключи - названия курсов,
        //  значения - мапа,
        //  в которой  ключи - продолжительность курса,
        //  а значения - списки курсов с указанной в ключе продолжительностью
    }
}
