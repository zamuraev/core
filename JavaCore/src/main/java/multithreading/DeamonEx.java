package multithreading;

import org.w3c.dom.ls.LSOutput;

//Thread - это user поток; deamon поток работает до тех пор пока активен хотя бы один user поток.
// если нет больше активных user потоков то deamon поток останавливает свою работу, не зависимо от того, завершил он свои задачи или нет
public class DeamonEx {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("user_thread");
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setName("deamon_thread");
        deamonThread.setDaemon(true);
        userThread.start();
        deamonThread.start();
        System.out.println("Main thread ends");
    };
}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is deamon " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DeamonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is deamon " + isDaemon());
        for (int i = 0; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}