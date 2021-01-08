package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test4 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        //находим произведение всех элементов в коллекции
        //на выходе методом get получаем этот один элемент
        //Optional оборачивает элемент который мы получаем на выходе, может содержать null и not null значения
        int result = list.stream().reduce((accumulator, element) -> accumulator*element).get();
        System.out.println(result);
        System.out.println("=================");
        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> o = list.stream().reduce((accumulator, element) -> accumulator*element);
        //устанавливаем первичное значение аккумулятора -  Optional<Integer> o = list.stream().reduce(1, (accumulator, element) -> accumulator*element);
        if (o.isPresent()) {
            System.out.println(o);
        } else {
            System.out.println("Not present");
        }

        List<String> list3= new ArrayList<>();
        list3.add("privet");
        list3.add("kak dela?");
        list3.add("OK");
        list3.add("poka");
        String result3 = list3.stream().reduce((a,e) -> a+ " "+e).get();
        System.out.println(result3);




    }
}
