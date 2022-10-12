package ru.itmo.lessons.lesson10;

import java.util.Objects;

// implements Cloneable необходимо,
// если происходит вызов метода super.clone();
public class Point implements Cloneable{
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // protected Object clone()
    // переопределние метода clone класса Object
    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование не поддерживается");
            return null;
        }
    }


    // переопределние метода equals класса Object
    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (!(object instanceof Point)) return false;
        Point point = (Point) object;
        return x == point.x && y == point.y;
    }

    // переопределние метода hashCode класса Object
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    // переопределние метода toString класса Object
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
