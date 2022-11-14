package ru.itmo.lessons.patterns.builder;

public class Builder {
    public static void main(String[] args) {
        NutritionFacts f01 = new NutritionFacts.Builder(100)
                .calories(400)
                .fat(10)
                // ...
                .build();

        NutritionFacts f02 = new NutritionFacts.Builder(400)
                .calories(20)
                // ...
                .build();
    }
}