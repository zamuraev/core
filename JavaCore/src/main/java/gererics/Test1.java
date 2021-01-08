package gererics;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    //цель - типобезопасность и reusable code
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("Ok");
//        list.add(5);
//        list.add(new StringBuilder("asdfghjkl"));
//        list.add(new Car());

        list.add("privet");
        list.add("poka");
        list.add("ok");
        list.add("vvfHFghghGvghVG");
        //list.add(new Car());

        for (Object s : list) {
            System.out.println(((String) s).length());
        }
    }

    static class Car {
    }
}
