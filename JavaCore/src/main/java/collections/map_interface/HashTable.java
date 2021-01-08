package collections.map_interface;

//устаревший класс, работает по тем же принципам что и HashMap, нужен для многопоточности, является synchronized
//ни ключ, ни значение не могут быть null

import java.util.Hashtable;

public class HashTable {

    public static void main(String[] args) {
        Hashtable<Double, Student> hashTable = new Hashtable<>();

        Student st1 = new Student("Sergey", "Zamuraev", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);

        hashTable.put(7.8, st1);
        hashTable.put(9.3, st2);
        hashTable.put(5.8, st3);
        hashTable.put(6.0, st4);

        System.out.println(hashTable);
    }
}