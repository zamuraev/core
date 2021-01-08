package collections.thread_safe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {

    //информация хранится в виде бакетов (в бакете хранится ключ-значение) - при чтении все равно сколько потоков читает, при записи блокируется только тот бакет в котором происходит модификация, а не вся коллекция целиком

    public static void main(String[] args) throws InterruptedException {
        //HashMap<Integer, String> map = new HashMap<>();
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Sergey");
        map.put(2, "Oleg");
        map.put(3, "Peter");
        map.put(4, "Ivan");
        map.put(5, "Igor");

        //нельзя итерироватся по коллекции в одном потоке и модифицировать ее во втором
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator(); //у самого map нет итератора, зато он есть в KeySet
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i +":"+map.get(i)); //во время итерации блока не было
            }
        };

        Runnable runnable2 = () -> {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(6, "Elena"); //во время добавления был залочен только один сегмент ConcurrentHashMap
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
