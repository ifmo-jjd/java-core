package ru.itmo.lessons.lesson20;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(45, 67);
        Point b = new Point(67, 12);
        Point c = new Point(89, -8);


        BinHandler<Point> pointHandler = new BinHandler<>();
        pointHandler.writeToFile(a);

        //lesson20.bin: ru.itmo.lessons.lesson20.Point x=45, y=67

        Point aFromFile = pointHandler.readFromFile();
        // ru.itmo.lessons.lesson20.Point
        // x = 45
        // y = 67
        // description - значение по умолчанию
        // для transient свойств восстанавливаются значения по умолчанию


        Figure figure = new Figure(3);
        figure.addPoint(a);
        figure.addPoint(b);
        figure.addPoint(c);

        BinHandler<Figure> figureHandler = new BinHandler<>();
        figureHandler.writeToFile(figure);

        Figure figureFromFile = figureHandler.readFromFile();

        System.out.println(a.equals(aFromFile));
        System.out.println(figureFromFile.equals(figure));
    }
}
