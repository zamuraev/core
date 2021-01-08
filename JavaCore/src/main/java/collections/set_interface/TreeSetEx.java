package collections.set_interface;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {

    //хранит элементы в отсортированнном по ключу по возрастанию порядке
    //TreeMap - ключ это элемент TreeSet , значение - костанта-заглушка
    //null не хранит

    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(10);

        System.out.println(treeSet);

        treeSet.remove(2); //удаление элемента из коллекции

        treeSet.contains(5); // содержит ли такой элемент



    }
}
