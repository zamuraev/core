package collections.list_interface.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods5 {

    public static void main(String[] args) {

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Sergey");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");
        List<String> myList = arrayList1.subList(1,4); //это не отдельная сущность а view (представление) на основной массив arrayList1. если в него добавить массив то он добавится и в arrayList1
        System.out.println(myList);

//        //toArray -> из листа получим массив типа Object
//        Object[] array = arrayList1.toArray();
//        //toArray с указанием типа данных
//        String[] array2 = arrayList1.toArray(new String[0]);
//        for (String s : array2) {
//            System.out.println(s);
//        }

        //List.of
        //List.copyOf
        //на выходе получим неизменяемые листы -> изменять нельзя, вылетет unsupportedOperationExeption
        List<Integer> list1 = List.of(3,8,13); //нельзя добавлть тип null
        System.out.println(list1);
        //list1.add(100); //так изменять нельзя, вылетет unsupportedOperationExeption
        List<String> list2 = List.copyOf(arrayList1);
        System.out.println(list2);

//        ArrayList<String> arrayList2 = new ArrayList<>();
//        arrayList2.add("Mariya");
//        arrayList2.add("Ivan");
//        arrayList2.add("Igor");

        //removeAll
        //arrayList1.removeAll(arrayList2);
        //System.out.println(arrayList1);

        //retainAll -> оставит в list1 только те элементы которые есть в list 2. остальные будут удалены
        //arrayList1.retainAll(arrayList2);
        //System.out.println(arrayList1);

        //containsAll -> буленовский, проверит содержит ли массив list1 все элементы массива list2
//        boolean result = arrayList1.containsAll(arrayList2);
//        System.out.println(result);

        //sublist -> создает из имеющегося Arraylist отрывок на заданную длину. 2й параметр метода не вклюен в длину



    }
}
