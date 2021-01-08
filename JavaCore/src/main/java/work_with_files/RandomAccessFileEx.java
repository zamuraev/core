package work_with_files;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {

    public static void main(String[] args) {
        try {
            try(RandomAccessFile file = new RandomAccessFile("test104.txt", "rw")) { //mode rw означает read\write - можно как писать в файл, так и читать из него
                int a = file.read(); //прочитает 1 байт на позиции где стоит pointer (курсор)
                System.out.println((char) a);
                String s1 = file.readLine(); //читаем всю строку
                System.out.println(s1);

                file.seek(101); //перемещаем курсор на позицию 101, и выводим значение
                String s2 = file.readLine();
                System.out.println(s2);

                long position = file.getFilePointer(); //получаем значение, на какой позиции находится наш курсор
                System.out.println(position);

                file.seek(0);
                file.writeBytes("privet"); //не добавим новые байты, а запишем поверх старых байтов

                file.seek(file.length()-1); //переходим в конец листа и делаем новую запись
                file.writeBytes("\n\t\t\t\t\tWilliam Butler Yeats");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}