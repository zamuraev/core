package work_with_files;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx {

    public static void main(String[] args) throws IOException {
        File file = new File("test101.txt");
        File folder = new File("A");
        File newfile = new File("test105.txt");
        File newfolder = new File("B");

        //показать абсолютный путь к файлу\директории
        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() " + folder.getAbsolutePath());
        System.out.println("---------------");
        //проверить, абсюлютный путь к файлу\директории или нет
        System.out.println("file.isAbsolute() " + file.isAbsolute());
        System.out.println("folder.isAbsolute() " + folder.isAbsolute());
        System.out.println("---------------");
        //проверить, является ли файл директорией
        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("folder.isDirectory() " + folder.isDirectory());
        System.out.println("---------------");
        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("folder.isDirectory() " + folder.isDirectory());
        //можно подать путь к файлу или папке, которой не существует. exeption не вылетет
        System.out.println("---------------");
        System.out.println("newfile.exists() " + newfile.exists());
        System.out.println("newfolder.exists() " + newfolder.exists());
        System.out.println("---------------");
        //создаем новый файл и новую директорию
        System.out.println("newfile.createNewFile() " + newfile.createNewFile());  //создаем новый файл
        System.out.println("newfolder.mkdir() " + newfolder.mkdir()); //создать новую директорию - make directory
        System.out.println("newfile.exists() " + newfile.exists());
        System.out.println("newfolder.exists() " + newfolder.exists());
        System.out.println("---------------");
        //узнать размер файла или папки
        System.out.println("newfile.length() " + newfile.length());
        System.out.println("newfolder.length() " + newfolder.length());
        System.out.println("---------------");
        //удалить файл\папку
        System.out.println("newfile.delete() " + newfile.delete());
        System.out.println("newfolder.delete() " + newfolder.delete()); //таким образом можно удалить папку, если она пустая, если она содержит файлы - нет: сначала нужно будет удалить из такой папки всю информацию и все файлы
        System.out.println("---------------");
        //проверить содержимое папки
        File[] files = folder.listFiles(); //возвращает массив типа File[], что содержит папка
        System.out.println(Arrays.toString(files));
        System.out.println("---------------");
        //проверить, скрытая ли папка
        System.out.println("file.isHidden() " + file.isHidden());
        System.out.println("---------------");
        //проверить уровень доступа к файлу
        System.out.println("file.canRead() " + file.canRead()); //на чтение
        System.out.println("file.canWrite() " + file.canWrite()); //на запись
        System.out.println("file.canExecute() " + file.canExecute()); //на выполнение файла
    }
}