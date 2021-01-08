package work_with_files;

import java.io.*;

public class BufferedEx {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test101.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("test102.txt"))
        ) {

            //работаем посимвольно
//            int character;
//            while ((character = reader.read()) != -1) {
//                writer.write(character);

            //работаем с целой строкой - читаем построчно
            String line;
            while((line=reader.readLine())!=null) {
                writer.write(line);
                writer.write('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
