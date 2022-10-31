package ru.itmo.lessons.lesson13.wildcard;

import ru.itmo.lessons.lesson13.properties.PairContainer;

public class WildcardsApp {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Animal> container1 = new PairContainer<>(1, animal);
        PairContainer<Integer, Cat> container2 = new PairContainer<>(1, cat);
        PairContainer<Integer, Object> container3 = new PairContainer<>(1, new Object());

        // WildcardsApp.<Animal>copyValue(container3, container1);
        // WildcardsApp.<Animal>copyValue(container2, container1);
        // WildcardsApp.<Cat>copyValue(container2, container3);
        // WildcardsApp.<Cat>copyValue(container1, container3);

        /* ? extends T - тип T и его потомки, */
        /* ? super T - тип T и его предки */
    }

    public static <T> void copyValue(
            PairContainer<Integer, ? extends T> from,
            PairContainer<Integer, ? super T> to
    ){
        to.setValue(from.getValue());
    }
}