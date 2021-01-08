package collections.list_interface.arrayList;

import java.util.*;

public class ArrayListMethods1 {

    public static void main(String[] args) {
        //Методы:
        //add
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Sergey");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");

        for (String s : arrayList1) {
            System.out.println(s);
        }

        //add with index
        arrayList1.add(0, "Misha");
        //если добавить arrayList1.add(5, "Mariya") то выпадет IndexOutOfBoundsException

        //нельзя создавать ArrayList с примитивными типами данных
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(6);

        //get
        System.out.println(arrayList1.get(2));

        //set - вставляет элемент массива на определеный индекс
        //не добавит, а именно заменит
        arrayList1.set(1, "Lera");

        //вывести все елементы через цикл for
        for(int i =0; i<arrayList1.size();i++) {
            System.out.println(arrayList1.get(i));
        }

        //remove
        arrayList1.remove(0);




    }





}
