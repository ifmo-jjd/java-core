package ru.itmo.lessons.lesson13.methods;

public class MethodsApp {
    public static void main(String[] args) {
        String[] strings = {"qwe", "asd", "zxc"};
        String string = "asd";
        // public static <T> boolean inArray(T[] array, T element)
        System.out.println(CustomUtils.inArray(strings, 12));
        System.out.println(CustomUtils.<String>inArray(strings, string));

        Integer[] integers = {34, 876577, 1005646};
        Integer integer = -34;
        System.out.println(CustomUtils.<Integer>inArray(integers, integer));

        // public static <T extends Number, K extends String>
        System.out.println(CustomUtils.compareHashCode(integer, string));
        System.out.println(CustomUtils.
                <Integer, String>compareHashCode(12, "12"));


    }
}
