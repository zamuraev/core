package work_with_files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

    public static void main(String[] args) throws IOException {

            try (FileReader reader= new FileReader("test101.txt")) {
            int character;
            while ((character = reader.read()) != -1) { //читает посимвольно, возвращает int чтобы можно было понять когда конец файлы. конец файла - возвращает -1
                System.out.println((char) character);
            }
            System.out.println();
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}