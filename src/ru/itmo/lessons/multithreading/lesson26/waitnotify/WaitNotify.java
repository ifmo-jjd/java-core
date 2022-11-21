package ru.itmo.lessons.multithreading.lesson26.waitnotify;

// методы класса Object для работы с многопоточностью:
// можно вызвать только в synchronized блоке или методе
// wait(); - приостанавливает работу текущего потока до тех пор,
// пока не будет разбужен методом notify из другого потока
// wait(млс); - или пока не пройдет указанное количество млс
// поток может проснуться сам

// notify(); - возобновляет работу случайного потока, который был
// приостановлен методом wait. Нельзя указать, какой именно поток
// должен возобновить работу. Нельзя указать очередность пробуждения
// потоков
// notifyAll(); - возобновляет работу всех потоков, которые
// были приостановлены методом wait
// notify / notifyAll не пробуждают потоки,
// которые приостановлены методом sleep
public class WaitNotify {
    public static void main(String[] args) {
        Library library = new Library();

        new PutThread(library).start();
        new GetThread(library).start();
        new PutThread(library).start();
        new GetThread(library).start();
    }

    static class GetThread extends Thread{
        private Library library;

        public GetThread(Library library) {
            this.library = library;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    library.getBook();
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class PutThread extends Thread{ // производитель
        private Library library;

        public PutThread(Library library) {
            this.library = library;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                    library.addBook(new Library.Book());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
