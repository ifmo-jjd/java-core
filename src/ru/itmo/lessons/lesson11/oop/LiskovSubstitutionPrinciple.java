package ru.itmo.lessons.lesson11.oop;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Том");

        Dog dog = new Dog();
        dog.setName("Граф");

        Human human = new Human();
        human.catchAnimal(cat);
        human.catchAnimal(dog);
    }
}
abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract String saySomething();
}

class Cat extends Animal {

    @Override
    String saySomething() {
        return "Мяу";
    }
}

class Dog extends Animal {

    @Override
    String saySomething() {
        return "Гав";
    }
}


class Human {
    private Animal[] animals = new Animal[10];
    public void catchAnimal(Animal animal){
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                System.out.println(animal.saySomething());
                animals[i] = animal;
            };
        }
    }
}