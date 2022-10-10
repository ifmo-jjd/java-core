package ru.itmo.lessons.lesson9.staticmod;

public class App {
    public static void main(String[] args) {
        // Util util1 = new Util();
        // Util util2 = new Util();

        // util1.max = 1200;
        // System.out.println(util2.max); // 1200

        // util2.min = 100;
        Util.min = 200; // +

        // System.out.println(util2.max); // 1200
        // System.out.println(util1.min); // 200

        System.out.println(Util.PI); // +
        System.out.println(Util.random(2, 67)); // +
    }
}