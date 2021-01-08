package work_with_files;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PathAndFilesEx1 {

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("test106.txt");  //путь к файлу
        Path directoryPath = Paths.get("M");    //путь к директории

        System.out.println(filePath.getFileName()); //возвращает имя файла или директории
        System.out.println(filePath.getParent()); //возвращает имя родителя (директории) для файла или директории
        System.out.println(filePath.isAbsolute()); //проверяет абсолютный ли путь или нет
        System.out.println(filePath.toAbsolutePath()); //показывает абсолютный путь
        System.out.println(filePath.toAbsolutePath().getParent()); //родительская директория для файла
        System.out.println(filePath.toAbsolutePath().getRoot()); //корень для относительного пути
        System.out.println(directoryPath.resolve(filePath));  //путь к директории присоединен к имени файла

        if(!Files.exists(filePath)) {
            Files.createFile(filePath); //если файла не существует, то создаст файл
        }
        if(!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath); //если директории не существует, то создаст директорию
        }

        //проверить права доступа на файл
        System.out.println(Files.isReadable(filePath)); //на чтение
        System.out.println(Files.isWritable(filePath)); //на запись
        System.out.println(Files.isExecutable(filePath)); //на запуск

        //проверить ссылаются ли файлы на один и тот же путь
        Path filePath2 = Paths.get("test105.txt");
        System.out.println(Files.isSameFile(filePath, filePath2));

        //посмотреть размер нашего файла, в байтах
        System.out.println(Files.size(filePath));

        //узнать атрибут у файла
        System.out.println(Files.getAttribute(filePath, "creationTime"));
        System.out.println(Files.getAttribute(filePath, "size"));

        System.out.println("-------------------");
        Map<String, Object> attributes = Files.readAttributes(filePath, "*");  //прочитать все атрибуты файла, возвращает map из атрибутов
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
        System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
