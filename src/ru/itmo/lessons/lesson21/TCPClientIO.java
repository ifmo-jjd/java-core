package ru.itmo.lessons.lesson21;

import ru.itmo.lessons.lesson21.common.Connection;
import ru.itmo.lessons.lesson21.common.Message;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientIO {
    private final String ip; // адрес серверной машины
    private final int port; // порт, на котором серверная программа ожидает клиента

    public TCPClientIO(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = scanner.nextLine();

        while (true){
            System.out.println("Введите сообщение");
            String text = scanner.nextLine();

            if ("/exit".equalsIgnoreCase(text)){
                System.out.println("Закрытие приложения");
                return;
            }

            Message message = new Message(name, text);

            try (Connection<Message> connection =
                         new Connection<>(new Socket(ip, port))){
                connection.sendMessage(message);
                Message fromServer = connection.readMessage();
                System.out.println("Сообщение от сервера: " + fromServer);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Обработка IOException и ClassNotFoundException");
            } catch (Exception e) {
                System.out.println("Обработка Exception");
            }
        }
    }

    public static void main(String[] args) {
        new TCPClientIO("127.0.0.1", 8090).run();
    }
}
