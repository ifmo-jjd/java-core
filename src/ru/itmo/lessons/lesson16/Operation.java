package ru.itmo.lessons.lesson16;
// интерфейс без методов - интерфейс-маркер

// интерфейс с одним абстрактным методом (количество default и static
// методов не имеет значения) - функциональный интерфейс

@FunctionalInterface // начиная с java 8
public interface Operation {
    double execute(double a, double b);
}


