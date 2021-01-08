package collections.set_interface;

import java.util.HashSet;

public class HashSetEx2 {

    public static void main(String[] args) {

        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(5);
        hashSet2.add(8);

        //union - обьединение наших множеств, метод addAll(), обьеденит и 1й и 2ю коллекции
        HashSet<Integer> union = new HashSet<>(hashSet2);
        union.addAll(hashSet2);
        System.out.println(union);

        //пересечение множеств - оставит только элементы которые есть и в 1й, и во 2й коллекции, retainAll()
        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);
        System.out.println(intersect);

        //subtract - разность множеств, удалит из 1й коллекции одинаковые элементы из 2й коллекции, метод removeAll()
        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2);
        System.out.println(subtract);



    }
}