package collections.queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeEx {

    //двунаправленная очередь
    //Queue->Deque->ArrayDeque
    //LinkedList тоже двунаправленная очередь, и у нее также есть все приведенные тут методы для работы с началом и концом очереди
    // в обычной очереди мы можем добавлять элементы только в конец, но в Deque мы можем добавить\удалять как в конец, так и в начало очереди
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3); //добавление в начало очереди
        deque.addFirst(5);
        deque.addLast(7); //добавляение в конец очереди
        deque.offerFirst(1); //добавляение в начало очереди, если очередь ограничена - exeption не вылетает
        deque.offerLast(8); //добавляение в конец очереди, если очередь ограничена - exeption не вылетает

        deque.removeFirst(); // удаляет с начала очереди, если элементов в очереди нет - вылетает exeption
        deque.pollFirst(); // удаляет с начала, но если элементов больше нет, exeption не вылетает
        deque.removeLast(); // удаляет с конца очереди, если элементов в очереди нет - вылетает exeption
        deque.pollLast(); // удаляет с конца очереди, но если элементов больше нет, exeption не вылетает

        deque.getFirst(); // возвращает элемент с начала очереди, если элементов в очереди нет, то вылетает exeption
        deque.peekFirst(); // возвращает элемент с начала очереди, но если элементов в очереди нет, exeption не вылетает
        deque.getLast(); // возвращает элемент с конца очереди, если элементов нет вылетает exeption
        deque.peekLast(); // возвращает элемент с конца очереди, но если элементов в очереди нет, exeption не вылетает

        System.out.println(deque);

    }

}
