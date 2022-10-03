package ru.itmo.lessons.lesson6;

import ru.itmo.lessons.lesson6.books.Author;
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

// полное имя класса: имя пакета + имя класса, например
// ru.itmo.lessons.lesson6.Application
public class Application {
    public static void main(String[] args) {
        // объект типа Author / экземпляр класса Author
        // типДанных имяПеременной = new вызовКонструктора();
        Author author1 = new Author();
        Author author2 = new Author();

        // обращение к свойствам осуществляется через .
        author1.name = "Tom";
        author1.surname = "Crowed";

        System.out.println(author2.name); // null
        System.out.println(author2.surname); // null

        author2.name = "Mike";
        author2.surname = "Thompson";

        System.out.println(author2.name); // Mike
        System.out.println(author2.surname); // Thompson

        System.out.println(author1);

        // вызов метода осуществляется через .
        author1.printFullName(); // void
        String fullName = author2.getFullName();

        System.out.println(fullName);


        Book book1 = new Book();
        book1.setPageCount(22);
        System.out.println(book1.getPageCount());
        book1.setAuthor(author1);

        System.out.println(book1);

        Book book2 = new Book();
        book2.setPageCount(1300);
        System.out.println(book2.getPageCount());
        book2.setAuthor(author1);

        Book book3 = new Book();
        book3.setPageCount(670);
        System.out.println(book3.getPageCount());
        book3.setAuthor(author2);

        Book book4 = new Book();
        book4.setPageCount(670);
        System.out.println(book4.getPageCount());
        book4.setAuthor(author2);

        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book2);
        shelf.addBook(book3);
        shelf.addBook(book4);

        System.out.println(shelf);

    }
}
