package collections.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx1 {
    //producer - добавляет элеметы в конец очереди, consumer - забирает элементы из начала очереди
    //тут пример по типу задачи на wait/notify - если коллекция полная то поток producer будет ждать пока поток consumer не заберет один элемент;

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4); //у очереди есть размер, в даном варианте она может содержать только 4 елемента
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        //queue.add(5); - еслм через add() добавлять - вылетет exeption, если добавлять через метод offer() - элемент просто не добавится
        System.out.println(queue);

    }

}
