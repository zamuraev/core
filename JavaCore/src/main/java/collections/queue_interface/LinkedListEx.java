package collections.queue_interface;


import java.util.LinkedList;
import java.util.Queue;

//Queue - это коллекция, хранящая последовательность элементов. Добавляется элемент в конец очереди, используется их начала очереди - правило FIFO.
//LinkedList имплементирует не только интерфейс List, но и Deque (->Queue)

public class LinkedListEx {

    public static void main(String[] args) {
        //принцип работы - удаляем из начала очереди, добавляем элементы в конец очереди
        Queue<String> queue = new LinkedList<>();
        queue.add("Sergey");
        queue.add("Zaur"); //добавление элемента в конец очереди, если очередь ограничена, то вылетет exeption
        queue.offer("Ivan"); //добавление элемента в конец очереди, если очередь ограничена, то exeption не вылетает, элемент не добавляется

        queue.remove("Zaur"); //удаляет и возвращает элемент, если елемента нет - выкидывает exeption
        queue.poll(); //удаляет первый элемент из начала очереди, но не выкидывает exeption, если элементов больше нет в коллекции
        queue.element(); //выводим на экран вверхний элемент из начала очереди, если елемента нет - выкидывает exeption
        queue.peek(); //выводим на экран вверхний элемент из начала очереди, но не выкидывает exeption если в очереди ничего больше не осталось



    }





}
