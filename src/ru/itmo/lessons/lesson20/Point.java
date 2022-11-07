package ru.itmo.lessons.lesson20;

import java.io.*;
import java.util.Objects;


public class Point implements Cloneable, /*Serializable*/ Externalizable {
    private static final long serialVersionUID = 1L;

    transient public final String description = "Для создания точки необходимо" +
            "указать 2 координаты";
    private int x;
    private int y;

    public Point(){} // требуется для Externalizable
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

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование не поддерживается");
            return null;
        }
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (!(object instanceof Point)) return false;
        Point point = (Point) object;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    // вызывается ObjectOutputStream при сериализации
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
    }
    // вызывается ObjectInputStream при десериализации
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readInt();
        y = in.readInt();
    }
}
