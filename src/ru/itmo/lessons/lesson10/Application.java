package ru.itmo.lessons.lesson10;

// class A extends B { }
// class B extends C { }
// Все классы наследуются от класса Object

// interface IA extends IB {}

// class A extends B implements IA {}



public class Application {
    public static void main(String[] args) {

        Point a = new Point(23, -12);
        Point b = new Point(23, -12);

        System.out.println(a); // System.out.println(a.toString());
        System.out.println(b); // System.out.println(b.toString());

        System.out.println(a == b); // false
        // по умолчанию метод equals сравнивает ссылки и д.б.
        // переопределен в классе
        System.out.println(a.equals(b)); // true

        // клонирование (создание копии объекта) метод clone
        Point aClone = a.clone();
        System.out.println(aClone == a); // false
        System.out.println(aClone.equals(a)); // true

        Figure figure = new Figure(2);
        figure.addPoint(a);
        figure.addPoint(b);

        System.out.println(figure); // System.out.println(figure.toString());

        Figure figureClone = figure.clone();
        System.out.println(figure.equals(figureClone)); // true
        System.out.println(figure.getPoints() == figureClone.getPoints()); // false
        System.out.println(figure.getPoints()[0] == figureClone.getPoints()[0]); // false

    }
}
