package gererics;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        List<?> list = new ArrayList<>();
        //при ? wildcart параметре нельзя будет вызывать методы, что изменяют наш обьект
        //нельзя будет вызвать list.add("hello");

        //bounded wild carts
        //Number и его наследники
        List<? extends Number> list3 = new ArrayList<>();

        //Number и супер классы для класса Number
        List<? super Number> list4 = new ArrayList<>();

        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("jkgjKJG");
        list2.add("uahguahg");
        list2.add("uauaug");
        showListInfo(list2);


        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.15);
        ald.add(3.16);
        System.out.println(summ(ald));

        ArrayList<String> stroka = new ArrayList<>();
        stroka.add("privet");
        stroka.add("poka");
        stroka.add("ok");
        //System.out.println(summ(stroka));
    }

    public static double summ(ArrayList<? extends Number> al) {
        double summ = 0;
        for(Number n : al) {
            summ += n.doubleValue();
        }
        return summ;
    }

    static void showListInfo(List<?> list) {
        System.out.println("Мой лист содержит следующие элементы: "+ list);
    }

}