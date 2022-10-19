package ru.itmo.lessons.lesson13.methods;

// generic типы
public class CustomUtils {
    // типизированные (generic) методы
    // методы могут принимать и возвращать generic типы
    public static <T> boolean inArray(T[] array, T element){
        // у T параметров можно вызвать только методы Object
        // при компиляции тип T преобразуется в Object
        for (T t : array) {
            if (element.equals(t)) return true;
        }
        return false;
    }

    // public static <T, K> int compareHashCode(T first, K second)
    // типы T и K скомпилируются в Object
    // для T и K типов доступны только методы Object

    public static <T extends Number, K extends String>
    int compareHashCode(T first, K second){
        // T скомпилируется в Number
        // K скомпилируется в String
        // у first (T) можно вызвать методы Number и его родителей
        // у second (K) можно вызвать методы String и его родителей
        // при вызове compareHashCode:
        //    T - Number или любым его наследником
        //    K - String или любым его наследником
        return Integer.compare(first.hashCode(), second.hashCode());
    }
}
