package ru.itmo.lessons.lesson20;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(45, 67);
        Point b = new Point(67, 12);
        Point c = new Point(89, -8);

        Figure figure = new Figure(3);
        figure.addPoint(a);
        figure.addPoint(b);
        figure.addPoint(c);
    }
}
