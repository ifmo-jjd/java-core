package ru.itmo.lessons.lesson20;

import java.io.*;

public class BinHandler<T> {
    private File file;
    public BinHandler() {
        file = new File("lesson20.bin");
    }
//    file+ - сериализация (ObjectOutputStream) - объект
    public void writeToFile(T object){
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)
            )
        {
            objectOutput.writeObject(object);
            // ObjectOutputStream - сериализация - превращает объект (object)
            // в последовательность байт
            // ObjectOutputStream вызывает метод write у потока, переданного ему
            // в конструктор (в данном случае fileOutput), поэтому
            // FileOutputStream записывает данную последовательность в файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // файл - десериализация -> объект
    public T readFromFile(){
        Object result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)
            )
        {
            result = objectInput.readObject(); //
            // ObjectInputStream вызывает метод read у потока, переданного ему
            // в конструктор (в данном случае fileInput), поэтому
            // осуществляется чтение последовательности байт из файла
            // ObjectInputStream преобразует полученную последовательность
            // в объект типа Object
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (T) result;
    }

}
