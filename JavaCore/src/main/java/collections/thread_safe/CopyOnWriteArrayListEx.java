package collections.thread_safe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {

    //при каждом изменении листа создает клон листа нового вида
    //на последней итерации ссылка на колеекцию будет указывать на самый актуальный вариант коллекции

    public static void main(String[] args) throws InterruptedException {
        //ArrayList<String> list = new ArrayList<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Sergey");
        list.add("Oleg");
        list.add("Sasha");
        list.add("Ivan");
        list.add("Igor");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
            list.add("Elena");    //перед тем как начали итерироватся по коллекции - итератору переделось состояние коллекции на момент создания итератора,
                                  //на операции изменения - создалась новая копия коллекции, в которую мы добавили элмент, и еще одна копия когда элемент удалили
                                   //последняя итерации при распечатке коллекции работает с самой новой копией коллекции
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}