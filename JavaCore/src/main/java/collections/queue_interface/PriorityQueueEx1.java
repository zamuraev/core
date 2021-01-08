package collections.queue_interface;

import java.util.PriorityQueue;

public class PriorityQueueEx1 {

    //очередь, которая будет хранить элементы в отсортированном виде, либо по натуральной сортировке, либо по Comparable, Comparator
    //не обращает никакого внимания на очередность добавления элементов
    //когда выводим элементы такой коллекции у них нет сортировки, сортировка только когда работаем с такой коллекцией
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(10);
        priorityQueue.add(8);

        //наивысший приоритет имеет наименьший элемент, котрый стоит самый первый в очереди после сортировки
        System.out.println(priorityQueue.peek()); //получаем верхний элемент очереди, элемент с наивысшим приоритетом.

        System.out.println(priorityQueue.remove()); //удаляем верхний элемент с наивысшим приоритетом

    }
}
