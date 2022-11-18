package ru.itmo.lessons.multithreading.lesson25;

public class Interrupting {
    public static void main(String[] args) {
        // фоновый поток завершает работу, когда
        // завершили работу все потоки, не являющиеся фоновыми
        Thread thread01 = new Thread(()->{
            while (true){
                System.out.println("Запись статистических данных в файл");
            }
        });

        thread01.setDaemon(true); // поток становится фоновым
        thread01.start();

        // thread01.stop(); не используется для остановки потока
        // других методов для остановки потока не существует

        // Завершение потока происходит в следующих ситуациях:
        // 1. если выброшено необработанное исключение
        // 2. остановилась jvm
        // 3. поток является фоновым и все потоки,
        // не являющиеся фоновыми завершили работу
        // 4. все инструкции потока выполнены

        // Thread:
        // свойство interrupted = false
        // метод isInterrupted() - возвращает значение свойства interrupted
        // метод interrupt() - меняет значение interrupted на true
        // (метод не останавливает поток, просто меняет значение свойства)

        Thread thread02 = new Thread(()->{ // создание потока
           while (!Thread.currentThread().isInterrupted()) {
               System.out.println("инструкции потока");

               // Если метод interrupt() будет вызван, когда поток
               // находится в состоянии ожидания, то будет выброшено
               // InterruptedException. Это приведет к тому, что
               // значение свойства interrupted снова изменится на false
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
           }
        });
        thread02.start(); // передача планировщику и последующий запуск потока

        // метод вызывается в зависимости от логики программы
        thread02.interrupt(); //  interrupted = true











    }
}
