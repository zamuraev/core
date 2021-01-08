package work_with_files;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTree {

    //обход каталога файлов и папок
    //нужно настроить методы из интерфейса FileVisitor

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\zamur\\Desktop\\JAVA Коллекция видеокурсов на Junior\\JavaCore");
        Files.walkFileTree(path, new MyFileVisitor());


    }
}

//используем файл FileVisitor

class MyFileVisitor implements FileVisitor<Path> {
    public MyFileVisitor() {
        super();
    }

    //перед заходом в директорию
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to directory" + dir);
        return FileVisitResult.CONTINUE; //продолжаем смотреть файлы и директории
    }

     //когда исследуется какой-то файл
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File name"+file.getFileName());
        return FileVisitResult.CONTINUE; //продолаем дальше обход по дирректории
    }

    //выпадает ошибка при изучении файла
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error while visiting file" + file.getFileName());
        return FileVisitResult.TERMINATE; //заканчиваем проход по файловому дереву
    }

    //после выхода из директории
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from Directory: "+dir);
        return FileVisitResult.CONTINUE;
    }
}