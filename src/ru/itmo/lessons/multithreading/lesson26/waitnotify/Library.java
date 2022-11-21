package ru.itmo.lessons.multithreading.lesson26.waitnotify;


import java.util.ArrayList;

// поток производитель / поток получатель (потребитель)
public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // не более 5 книг
    public synchronized void addBook(Book book) throws InterruptedException {
        // if (books.size() >= 5) wait(); // поток, который вызывает
        // метод addBook переходит в ожидание
        while (books.size() >= 5) {
            wait(); // если поток произвольно выйдет из ожидания,
            // программа перейдет к проверке условия,
            // а не к безусловному добавлению книги (как в случае с if)
        }
        books.add(book);
        System.out.println("книга добавлена " + books.size());
        notify();
    }
    // нельзя получить книгу из пустой коллекции
    public synchronized Book getBook() throws InterruptedException {
        // if (books.size() == 0) wait();
        while (books.size() == 0) {
            wait();
        }
        Book book = books.remove(0);
        System.out.println("книга удалена " + books.size());
        notify();
        return book;
    }


    public static class Book { }
}
