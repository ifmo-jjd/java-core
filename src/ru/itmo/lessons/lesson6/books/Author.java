package ru.itmo.lessons.lesson6.books;

// полное имя класса: ru.itmo.lessons.lesson6.books.Author
public class Author {
    // свойства, характеристики, поля, атрибуты
    // Значения свойств по умолчанию:
    // для ссылочных типов - null
    // для булевого типа - false
    // для целочисленного типа - 0
    // для чисел с плавающей точкой - 0.0
    public String name;
    public String surname;

    // методы
    public void printFullName(){
        // тело метода
        // можно использовать return; чтобы прерывает работу метода
        System.out.println(name + " " + surname);
    }

    public String getFullName(){
        // return - прерывает работу метода
        // возвращает результат работы методы
        return name + " " + surname;
    }


    // Alt + Insert
    // ПКМ (в рамках класса) -> Generate
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
