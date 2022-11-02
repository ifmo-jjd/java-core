package ru.itmo.lessons.lesson19;

import java.io.*;
import java.util.Scanner;

public class IO {
    private static boolean writeToFile(byte[] bytes, File file)
    /* throws FileNotFoundException */
    {
        boolean result = false;
        // try with resources java 7
        // в () можно создать экземпляры любого типа, если данный
        // имплементирует интерфейс AutoCloseable и реализует
        // его абстрактный метод close
        // если объект создан в (), метод close вызывается автоматически:
        // 1. если все инструкции try выполнены без ошибок
        // 2. если в блоке try произошла ошибка (метод вызывается сразу после
        // исключительной ситуации)
        try(FileOutputStream output = new FileOutputStream(file, true)) {
            // new FileOutputStream(file) - перезапись данных
            // new FileOutputStream(file, true) - дозапись данных
            // если файла не существует, он будет создан
            output.write(bytes);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось использовать файл");
            // throw new RuntimeException("Ошибка записи");
        } catch (IOException e) {
            System.out.println("Не удалось записать данные в файл");
            // throw new RuntimeException("Ошибка записи");
        }
        return result;
    }

    public static byte[] readFromFile(File file)
    /* throws IOException */
    {
        byte[] result = null;
        try (FileInputStream fileInput = new FileInputStream(file)){
            // если файл не найден, будет сгенерировано исключение
            result = fileInput.readAllBytes();
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
            System.out.println("Файл не найден");
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("Не удалось прочитать данные из файла");
        }
        System.out.println(new String(result));
        return result;
    }

    public static boolean writeFromConsole(File file){
        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file, true);
             // классы - декораторы
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutput)) {
            // new BufferedOutputStream(fileOutput) 8192
            // new BufferedOutputStream(fileOutput, 512) 512

            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Введите данные или stop для выхода");
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) break;
                buffer.write(userInput.getBytes());
                // fileOutput.write(накопленные байты);
            }
            result = true;
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
