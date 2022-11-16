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
    //команда `/help` - отобразить пользователю список доступных команд
    //команда `/count` - отобразить пользователю количество сообщений,
    // которые получил сервер (от всех клиентов)
    //команда `/ping` - время, за которое сообщение доходит до сервера и возвращается обратно
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

                Command command = Command.getCommand(fromClient.getText(), this);
                command.action();

                Message message = new Message("Server", "Сообщение от сервера");
                connection.sendMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Обработка IOException или ClassNotFoundException");
        }
    }

    public static void main(String[] args) {
        // Integer.parseInt(); -> возвращает int
        // Integer.valueOf(); -> возвращает Integer

        // что делать, если аргумент не задан, его нельзя преобразовать в int
        // или число не может быть использовано в качестве значения port?

        new TCPServerIO(Integer.parseInt(args[0])).run();
    }
}
