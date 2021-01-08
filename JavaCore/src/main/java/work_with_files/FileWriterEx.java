package work_with_files;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

    //ресурс что используется в try with resourses должен имплементировать Autoclosable

    public static void main(String[] args) {
        //для работы с текстовыми файлами
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно!\n" +
                "— Вот последняя правда, открытая мной.\n";
        String s = "privet\n";

        try (FileWriter writer = new FileWriter("test101.txt", true)) {    //true чтобы не затирало данные при добавлении в файл
            writer.write(rubai);
            writer.write(s);
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));    //передаем посимвольно данные, автоматический кастинг к int
                System.out.println("Done!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

