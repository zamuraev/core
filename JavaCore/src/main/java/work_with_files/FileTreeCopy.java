package work_with_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTreeCopy {

    //копирование вложенных файлов и директорий
    public static void main(String[] args) throws IOException {
        Path sourse = Paths.get("C:\\Users\\zamur\\Desktop\\JAVA Коллекция видеокурсов на Junior\\JavaCore\\X");
        Path destination = Paths.get("C:\\Users\\zamur\\Desktop\\JAVA Коллекция видеокурсов на Junior\\JavaCore\\X\\CopyX");
        Files.walkFileTree(sourse, new MyFileVisitor2(sourse, destination));
    }
}

//FileVisitor интерфейс, а SimpleFileVisitor это базовая его реализация чтобы не нужно было переопределять все методы
class MyFileVisitor2 extends SimpleFileVisitor<Path> {

    Path sourse;        //откуда идет копирование
    Path destination;  //куда идет копирование

    public MyFileVisitor2(Path sourse, Path destination) {
        this.sourse = sourse;
        this.destination = destination;
    }

    //перед заходом в директорию
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        Path newDestination = destination.resolve(sourse.relativize(dir));  //relativize находит относительный путь к папке - т.е. это ее название, цепляет к пути куда мы копируем назавание этот папки
        Files.copy(dir, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    //когда исследуется какой-то файл
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(sourse.relativize(file));  //relativize находит относительный путь к файлу
        Files.copy(file, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}