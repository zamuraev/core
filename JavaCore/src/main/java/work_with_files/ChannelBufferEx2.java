package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {

    public static void main(String[] args) {

        try (RandomAccessFile file = new RandomAccessFile("test105.txt", "r");
             FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(5);
            channel.read(buffer);    //читаем информацию из файла и записываем ее в буффер
            buffer.flip(); //читаем из буффера
            System.out.println((char) buffer.get()); //прочитали 3 байта
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());

            //прочитали 3 байта
            buffer.rewind(); // поместит курсос на позицию 0, и начнет снова читать с 0 позиции
            System.out.println((char) buffer.get()); //a

            System.out.println("-------------------");
            buffer.compact();         //непрочитанные элеметы копируются в начало буффера, и не будут затерты при новой записи в буффер в отличии от метода buffer.clear() который затрет все
            channel.read(buffer);    //читаем информацию из файла и записываем ее в буффер
            buffer.flip();          //читаем из буффера
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            System.out.println("-------------------");
            buffer.clear();
            channel.read(buffer);    //читаем информацию из файла и записываем ее в буффер
            buffer.flip();
            System.out.println((char) buffer.get());
            buffer.mark();  //поставили отметку
            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());
            buffer.reset(); //вернуть курсор на отметку
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}