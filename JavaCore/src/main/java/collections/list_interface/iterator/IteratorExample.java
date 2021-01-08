package collections.list_interface.iterator;

import java.util.ArrayList;

public class IteratorExample {


    public static void main(String[] args) {

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Sergey");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        //нужен чтобы обойти все элементы коллекции
        //с помощью итератора можно удалить элемент коллекции
//        Iterator<String> iterator = arrayList1.iterator();
//        while(iterator.hasNext()) {
//           iterator.next();
//           iterator.remove();
//
//            System.out.println(iterator.next());
//        }



    }
}
