package collections.list_interface.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {

    public static void main(String[] args) {

        //создается массив размером 10
        //capacity = 10 by default
        //в своей основе содержит массив типа Object

        //1
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Sergey");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1);

        //2
        ArrayList<String> arrayList2 = new ArrayList<>();

        //сразу массив на 200 элементов
        //3
        ArrayList<String> arrayList3 = new ArrayList<>(200);
        arrayList3.add("Sergey");
        arrayList3.add("Ivan");

        //4
        List<String> arrayList4 = new ArrayList<>();

        //5 содержит такое же элементы что и arrayList3 но это другой обьект
        ArrayList<String> arrayList5 = new ArrayList<>(arrayList3);






    }
}
