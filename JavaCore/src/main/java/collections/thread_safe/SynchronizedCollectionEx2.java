package collections.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionEx2 {

    //synchronizedList,...set, ...map это все обертки над однопоточными коллекция.
    //когда такую коллекцию захватывает поток там срабатывает лок на чтение-запись элементов, лок до тех пор пока поток не закончит работу с коллекцией
    //работа с такими коллекция будет менее эффективна чем работа с Concurrent Collections, где работа с потоками оптимизирована на уровне реализации самой коллекции

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i =0; i<1000; i++) {
            arrayList.add(i);
        }
        List<Integer> synchList = Collections.synchronizedList(arrayList);

        Runnable runnable1 = () -> {
            //remove - ставится lock, когда Iterator нужно прописать лок вручную
            synchronized (synchList) {
                Iterator<Integer> iterator = synchList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        Runnable runnable2 = () -> {
            synchList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchList);
    }
}
