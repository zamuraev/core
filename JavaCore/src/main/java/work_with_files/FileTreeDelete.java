package work_with_files;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTreeDelete {

    //удаление вложенных файлов и директорий - сначала удаляем файлы методом visitFile(), а затем удаляем опустошенную папку методом postVisitDirectory()
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\zamur\\Desktop\\JAVA Коллекция видеокурсов на Junior\\JavaCore\\X\\CopyX");
        Files.walkFileTree(path, new MyFileVisitor3());
    }
}

    //FileVisitor интерфейс, а SimpleFileVisitor это базовая его реализация чтобы не нужно было переопределять все методы
    class MyFileVisitor3 extends SimpleFileVisitor<Path> {

        //когда когда в директории исследуем какой-то файл то удаляем его
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Delete name: " + file.getFileName());
            Files.delete(file);
            return FileVisitResult.CONTINUE;
        }

        //заходим в папку -> удаляем все содержимое папки -> выходим из директории и удаляем ее
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("Delete Directory: "+dir.getFileName());
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
        }
}