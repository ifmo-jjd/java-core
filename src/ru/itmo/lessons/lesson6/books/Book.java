package ru.itmo.lessons.lesson6.books;

// полное имя класса: ru.itmo.lessons.lesson6.books.Book
public class Book {
    // свойства
    private String title;
    private int pageCount;
    private Author author;
    // private позволяет обращаться к свойствам и методам только
    // из текущего класса


    // конструктор по умолчанию public Book(){} позволяет
    // создать объекты new Book()
    public Book(){}

    // конструкторы должны отличаться типом и количеством аргументов
    public Book(String title){ // new Book("Java 17")
        this.title = title;
    }

    // new Book("Java 17", author1)
    public Book(String title, Author author) {
        this.title = title;
        setAuthor(author);
    }
    
    // методы, которые позволяют установить значения
    // private свойств - сеттеры
    public void setPageCount(int count) {
        if (count < 10) {
            throw new IllegalArgumentException("значение не м.б меньше 10");
        }
        pageCount = count;
    }

    // методы, которые возвращают значения
    // private свойств - геттеры
    public int getPageCount(){
        return pageCount;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("author не м.б null");
        }
        // this - ссылка на текущий объект
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}
