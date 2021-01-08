package work_with_files;

import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx1 {

    public static void main(String[] args) {
        try (RandomAccessFile file =
                     new RandomAccessFile("test104.txt", "rw");
             FileChannel channel = file.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(25); //устанавливаем размер буффера - если после полного заполнения буффера мы попытаемся еще добавить данные в него, будет выброшен exeption
            StringBuilder stix = new StringBuilder();

            int byteRead = channel.read(buffer); //прочитали в Channel 25 байт из файла и записали их в буффер
            while (byteRead > 0) { //количество пррочитанных байт из файла больше 0
                System.out.println("Read" + byteRead); //смотрим сколько байт прочитали

                buffer.flip(); //переключили буффер из режима записи в режим чтения
                                //читаем информацию из буфера по 1 байту за раз
                while (buffer.hasRemaining()) { //читаем пока у буффера есть остаток
                    stix.append((char) buffer.get()); //прочитали из буфера первые 25 байт и записали их в String Builder
                }

                buffer.clear(); //подгатавливаем буффер к записи
                byteRead = channel.read(buffer); //снова в channel прочитали 25 байт и записали их в буффер
            }
            System.out.println(stix);

            String text = "\nThere are only two ways to live yor life."
             + " One is as though nothing is a miracle. The other is as"
                    + " though everything is a miracle.";
            //записываем строку text в файл
//            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length); //устанавливаем размер буффера конкретно под данную цитату
//            buffer2.put(text.getBytes()); //записали цитату в буффер с помощью метода put()
//            buffer2.flip();  //теперь будем читать из буффера, чтобы channel прочитал информацию из буффера и записал в файл
//            channel.write(buffer2);

            ByteBuffer buffer2 = ByteBuffer.wrap(text.getBytes()); //передаем в буффер массив байтов из строки text
            channel.write(buffer2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}