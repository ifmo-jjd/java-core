package ru.itmo.lessons.lesson19;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIO {

    private static void readAllBytes(){
        Path fileName = Path.of("nio-data.txt");

        try(FileChannel inChannel = FileChannel.open(fileName)) {

            long fileSize = inChannel.size();

            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            buffer.flip();

            System.out.println(new String(buffer.array()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeToFile(String data){
        Path fileName = Path.of("nio-data.txt");

        try (FileChannel channel = FileChannel.open(fileName,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            byte[] strBytes = data.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);

            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        writeToFile("Данные для записи\n");
        readAllBytes();
    }
}
