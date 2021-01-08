package collections.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx2 {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

        //Producer
        new Thread(() -> {
            int i = 0;
            while (true) {
                // producer методом put() добавляет элемент в конец очередь, consumer - методом take() забирает элемент из начала очереди
                //put() ждет пока не освободится место для нового элемента чтобы добавить новый элемент, take() ждет пока в очереди появятся новые элементы;
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Producer add number " + i + " "+arrayBlockingQueue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //Consumer
        new Thread(() -> {
            while (true) {
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer get number " + j + " "+arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
