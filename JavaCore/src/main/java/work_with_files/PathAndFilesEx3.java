package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesEx3 {

    public static void main(String[] args) throws IOException {

        //записать информация в файл и считать из него
        Path filePath = Paths.get("test109.txt");
//        Files.createFile(filePath);
//        String dialog = "-Privet\n-Privet\n-Kak dela?\n-Xorosho! Kak u tebya?\n-Toje xorosho!";
//        Files.write(filePath, dialog.getBytes());   //записываем в файл, dialog переводим в массив байт

        //чтение из файла
        List<String> list = Files.readAllLines(filePath);
        for (String s : list) {
            System.out.println(s);
        }

    }
}