package collections.map_interface;

import java.util.LinkedHashMap;

public class LinkedHashMapEx {

    public static void main(String[] args) {

        //упорядоченная HashMap коллекция LinkedHashMap (capacity, loadFactory, accessOrder )
        //accessOrder = false (по порядку добавления элемента); true = порядок будет постоянно менятся в зависимости от того, какие элементы были использованы в каком порядке
        LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>(16, 0.75f);

        Student st1 = new Student("Sergey", "Zamuraev", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);

        linkedHashMap.put(7.5, st4);
        linkedHashMap.put(5.8, st1);
        linkedHashMap.put(6.4, st2);
        linkedHashMap.put(7.2, st3);

        System.out.println(linkedHashMap);

    }


}
