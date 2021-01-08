package work_with_files.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {

    public static void main(String[] args) {
        List<String> employees;

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees1.bin"))) {

           employees= (ArrayList) inputStream.readObject();  //производим кастинг к тому обьекту, который мы достаем из базы данных
            System.out.println(employees);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
