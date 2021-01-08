package collections.map_interface;

import java.util.Comparator;
import java.util.TreeMap;

//элементы хранятся в отсортированном по ключу по возрастанию порядке
public class TreeMapEx {

    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();

        Student st1 = new Student("Sergey", "Zamuraev", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);
        Student st5 = new Student("Vasiliy", "Smirnov", 1);
        Student st6 = new Student("Sasha", "Kapustin", 3);
        Student st7 = new Student("Elena", "Sidorova", 4);

//        TreeMap<Double, Student> treeMap = new TreeMap<>();

//        treeMap.put(5.8, st1);
//        treeMap.put(8.2, st6);
//        treeMap.put(7.5, st4);
//        treeMap.put(6.4, st2);
//        treeMap.put(9.1, st7);
//        treeMap.put(7.2, st3);
//        treeMap.put(7.9, st5);
//        treeMap.put(3.2, st8);
//
//        //развернуть treeMap не по возростанию, а по убыванию
//        System.out.println(treeMap.descendingMap());
//
//        //нахождение ренджа значений - больше значений метод tailMap()
//        // меньше значений - метод headMap()
//        System.out.println( treeMap.tailMap(7.3));
//        System.out.println( treeMap.headMap(7.3));
//
//        // последний элемент TreeMap
//        System.out.println(treeMap.lastEntry());
//
//        //начальный элемент коллекции
//        System.out.println(treeMap.firstEntry());
//
//        System.out.println(treeMap);

        TreeMap<Student, Double> treeMap1 = new TreeMap<>();
        treeMap1.put(st1, 5.8);
        treeMap1.put(st6, 8.2);
        treeMap1.put(st4, 7.5);
        treeMap1.put(st2, 6.4);
        treeMap1.put(st7, 9.1);
        treeMap1.put(st3, 7.2);
        treeMap1.put(st5, 7.9);

        System.out.println(treeMap1);

        //если нельзя имплементировать Comparable, в конструкторе TreeMap можно реализовать компаратор
        TreeMap<Student, Double> treeMap2 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.compareTo(o2);
            }
        });

        //при работе с Treemap нет необходимости в переопределении метода equals и hashCode. все сравнения будут идти через метод CompareTo
        //при использовании метода containsValue
        Student st8 = new Student("Elena", "Sidorova", 4);
        System.out.println(treeMap1.containsKey(st8));

    }
}