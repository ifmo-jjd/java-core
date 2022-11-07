package ru.itmo.lessons.lesson20;

import java.util.Arrays;

public class Figure {
    private final Point[] points;

    public Figure(int pointsCount) {
        if (pointsCount < 2) {
            throw new IllegalArgumentException("Фигура" +
                    "должна состоять из 2 и более точек");
        }
        this.points = new Point[pointsCount];
    }

    public Point[] getPoints(){
        return points;
    }

    public void addPoint(Point point) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                points[i] = point;
                System.out.println("Точка " + point + " была добавлена");
                return;
            }
        }
        System.out.println("Точка " + point + " не была добавлена." +
                "У фигуры достаточное количество точек.");
    }

    @Override
    public Figure clone() {
        Figure clone = new Figure(points.length);
        for (int i = 0; i < points.length; i++) {
            clone.points[i] = points[i].clone();
        }
        return clone;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (!(object instanceof Figure)) return false;
        Figure figure = (Figure) object;
        return Arrays.equals(points, figure.points);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
