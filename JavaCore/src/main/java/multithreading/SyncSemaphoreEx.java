package multithreading;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.Semaphore;


public class SyncSemaphoreEx {

    public static void main(String[] args) {

       //синхронизатор семафор - органичение на количество потоков которые могут запускать участок программы
        Semaphore callBox = new Semaphore(2);
        new Person("Sergey", callBox);
        new Person("Oleg", callBox);
        new Person("Elena", callBox);
        new Person("Viktor", callBox);
        new Person("Marina", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.callBox = callBox;
        this.name = name;
        this.start(); // при создании обьекта поток сразу запускается
    }

    // к этому ресурсу получают доступ одновременно callBox(2) потоков
    @Override
    public void run() {
        System.out.println(name + " ждет...");
        try {
            callBox.acquire(); //попытка получать разрещение от Semaphore
            System.out.println(name + " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            callBox.release(); // увеличивает счетчик Semaphore на 1, чтобы им мог воспользоватся новый поток; освобождаем доступ к ресурсу
        }
    }
}