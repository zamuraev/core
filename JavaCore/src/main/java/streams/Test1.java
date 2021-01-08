package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("OK");
        list.add("poka");

//        for(int i=0; i <list.size(); i++){
//            list.set(i, String.valueOf(list.get(i).length()));
//        }

        // map это интерфейс Function (Student -> Double)
        //collect - нужен чтобы преобразовать поток в лист
        List<Integer> list2 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list2);
        System.out.println("==============");
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).map(
                s -> {if (s%3==0) {
                    s = s/3;
                }
                return s;
                }).toArray();

        System.out.println(Arrays.toString(array));


        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("OK");
        set.add("poka");

        Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println(set2);

    }
}
