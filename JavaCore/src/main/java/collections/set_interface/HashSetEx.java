package collections.set_interface;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {


    //коллекция уникальных элементов
    //важно переопределять метод equels и hashcode
    //нет метода get()

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("Sergey");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
        set.add(null);

        set.remove("Sergey");

        for(String s: set) {
            System.out.println(s);
        }

        //размер коллекции
        System.out.println(set.size()); //

        //коллекция пустая или нет
        System.out.println(set.isEmpty());

        //содержит ли коллекция элемент
        System.out.println(set.contains("Misha"));
        System.out.println(set.contains("Marina"));



    }
}