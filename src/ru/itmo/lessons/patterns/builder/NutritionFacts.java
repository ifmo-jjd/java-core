package ru.itmo.lessons.patterns.builder;

public class NutritionFacts {
    // обязательные свойства
    private final int servings;
    // необязательные свойства
    private final int calories;
    private final int fat;

    // запрет создания объектов из вне,
    // т.к. за создание объектов должен отвечать только Builder
    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

    public static class Builder {
        // обязательные свойства
        private final int servings;
        // необязательные свойства
        private int calories = 1;
        private int fat = 1;

        // значение обязательных свойств задаются через конструктор
        public Builder(int servings) {
            this.servings = servings;
        }
        // для остальных свойств создаются сеттеры
        // проверки входящих данных осуществляются
        // в конструкторе и сеттерах класса - строителя
        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
}
