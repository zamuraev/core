package work_with_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//копируем файл картинку при помощи FileInputStream, FileOutputStream
public class CopyEx {

    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\zamur\\Desktop\\JAVA Коллекция видеокурсов на Junior\\JavaCore\\cheshir_cat.jpg");
             FileOutputStream outputStream = new FileOutputStream("C:\\Users\\zamur\\Desktop\\JAVA Коллекция видеокурсов на Junior\\JavaCore\\cheshir_cat_copy.jpg")
        ) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}