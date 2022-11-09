package ru.itmo.lessons.lesson21;

import ru.itmo.lessons.lesson21.common.Connection;
import ru.itmo.lessons.lesson21.common.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerIO {
    private int port;

    public TCPServerIO(int port) {
        this.port = port;
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");
            while (true){
                // сервер ждет клиента
                Socket socket = serverSocket.accept(); // дождался
                // взаимодействие с клиентом (получение и передача информации)
                Connection<Message> connection = new Connection<>(socket);

                Message fromClient = connection.readMessage();
                System.out.println("От клиента: " + fromClient);

                Message message = new Message("Server", "Сообщение от сервера");
                connection.sendMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Обработка IOException или ClassNotFoundException");
        }
    }

    public static void main(String[] args) {
        // FIXME:: Задание - запуск программы с аргументами (порт)
        new TCPServerIO(8090).run();
    }
}
