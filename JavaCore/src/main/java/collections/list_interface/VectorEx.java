package collections.list_interface;

import java.util.Vector;

public class VectorEx {

    //синхронизированный ArrayList для многопоточности, но старой версии
    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();
        vector.add("Sergey");
        vector.add("Misha");
        vector.add("Oleg");
        vector.add("Katya");
        System.out.println(vector);
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        vector.remove(2);
        System.out.println(vector);
        System.out.println(vector.get(1));

    }
}
