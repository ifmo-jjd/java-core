package ru.itmo.lessons.lesson9.question3;


public class Flower {
    private String name;
    private int price;
    private int rating;

    public Flower(String name, int price, int rating) {
        if (name.length() < 3) throw new IllegalArgumentException("Название не может быть короче 3 символов");
        if (price < 100) throw new IllegalArgumentException("Цена не может быть меньше 100");
        if (rating < 0 || rating > 5) throw new IllegalArgumentException("Рейтинг дб от 0 до 5");
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
    public static Flower createFlower(){
        String[] names = {"Лилия", "Роза", "Ромашка"};
        return new Flower(
                names[(int) (Math.random() * names.length)],
                (int) (100 + Math.random() * 900),
                (int) (Math.random() * 6)
        );
    }
}
