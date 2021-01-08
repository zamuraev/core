package collections.map_interface;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {

    //В основе HashMap лежит массив. Элементами данного массива (бакеты-ячейки) являются структуры LinkedList. Данные структуры LinkedList (Node) и заполняются элементами, которые мы добвляем в HashMap.
   //Map<Student, Double> map = new HashMap();
   //map.put(st1, 7.5);
   //
   //1) если key равен 0 - то элемент помещается на 0 индекс
   //находим hashcode по ключу - например 356. вычисляется index, допусти 3.
    // добавили в map следующий ключ, хэшкод которого тоже равен 356
    //в какете образуется нода(узел) из значений: "hashcode, key, value, указатель на следующий элемент"

    public static void main(String[] args) {


        //должны быть уникальные ключи, если пытаемся вставить элемент с ключом-дубликатом, то значение элемента под ключом перезапишется
        //можно добавить значение и с ключом null
        //ключи должны быть имьютабле, чтобы не менялся hashCode. поля final, сlass final
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000, "Sergey Zamuraev");
        map1.put(3568, "Ivan Ivanov");
        map1.put(6578, "Mariya Sidoriva");
        map1.put(15879, "Nikolay Petrov");
        System.out.println(map1);

        map1.putIfAbsent(1000, "Oleg Ivanov"); //по ключу, если значение в коллекции уже есть, то не добавит, если нет - то добавит
        System.out.println(map1);

        //вывод значение
        System.out.println(map1.get(1000));

        //удаление элемента
        map1.remove(6578);

        //итерирование по коллекции
        for (Map.Entry<Integer, String> map : map1.entrySet()) {
            System.out.println(map.getKey() + ": " + map.getValue());
        }

        //возвращает true, если в map есть определенное значение или ключ
        System.out.println(map1.containsValue("Sergey Zamuraev"));
        System.out.println(map1.containsKey(500));

        //возвращает множество всех ключей
        System.out.println(map1.keySet());

        //возвращает множество всех значений
        System.out.println(map1.values());



    }
}