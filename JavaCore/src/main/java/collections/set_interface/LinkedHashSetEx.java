package collections.set_interface;

import java.util.LinkedHashSet;

public class LinkedHashSetEx {

    //наследник HashSet, который хранит информацию о порядке добавления элементов
    //в основе лежит HashMap
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(10);
        System.out.println(lhs);
        lhs.remove(8);
        System.out.println(lhs);

        System.out.println(lhs.contains(8));
        System.out.println(lhs.contains(10));
    }
}
