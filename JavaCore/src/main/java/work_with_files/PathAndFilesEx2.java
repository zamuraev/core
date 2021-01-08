package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {

    public static void main(String[] args) throws IOException {
//
//        Path filePath = Paths.get("test106.txt");  //путь к файлу
//        Path directoryPath = Paths.get("M");    //путь к директории
//        Path directoryBPath = Paths.get("B");
//
//        //COPY
//        //передаем что копируем и куда копируем
//        //ипользуем метод resolve() - он объеденит путь и задаст имя для нового файла
//        Files.copy(filePath, directoryPath.resolve(filePath)); //если файл с таким же именем уже есть в папке то вылетит exeption
//        //если хотим перезаписать уже имеющийся файл. если такой файл уже есть - его нужно заменить
//        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
//        //копируем папку
//        Files.copy(directoryBPath, directoryPath.resolve("B"));
//        //если папка не пустая - обычным методом Copy получится скопировать только саму папку, без ее содержимого
//
//        //MOVE
//        //перемещяяем файл
//        Files.move(filePath, directoryBPath.resolve("test106.txt"));

        //переименовать файл и деректорию
        //для этого используем метод move()
//        Files.move(Paths.get("test107.txt"),Paths.get("test107.txt"));

        //удаление
//        Files.delete(Paths.get("test107.txt"));
            //мы не сможем удалить папку если она не пуста -> сначала из нее нужно удалить все файлы

    }
}
