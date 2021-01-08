package collections.list_interface.arrayList;

import java.util.ArrayList;

public class ArrayListMethods3 {

    public static void main(String[] args) {

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Sergey");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Ivan");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Bob");
        arrayList2.add("Paul");

        //addAll
        arrayList1.addAll(0, arrayList2);
        System.out.println(arrayList1);

        //clear - очищает arrayList
        //arrayList1.clear();
        System.out.println("------clear-----");
        System.out.println(arrayList1);

        //indexof -> сравнение также идет при помощи метода equals
        //если есть дубликаты - позиция первого нахождения
        System.out.println(arrayList1.indexOf("Ivan"));
        //последние совпадение
        System.out.println(arrayList1.lastIndexOf("Ivan"));

        //size() - размер массива
        System.out.println(arrayList1.size());

        //isEmpty
        //возвращает true или false в зависимости от того пустой массив или нет
        System.out.println(arrayList1.isEmpty());

    }
}
