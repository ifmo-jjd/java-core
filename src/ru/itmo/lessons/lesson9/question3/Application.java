package ru.itmo.lessons.lesson9.question3;

public class Application {

    public static void main(String[] args) {
        Flower[] flowers = new Flower[10];

        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = Flower.createFlower();
        }

        for (Flower flower : flowers) {
            System.out.println(flower);

        }
    }
}
