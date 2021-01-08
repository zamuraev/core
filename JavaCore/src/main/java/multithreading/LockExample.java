package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) throws InterruptedException {
        Call call = new Call();

        new Thread(() -> { new Call().skypeCall();}).start();
        new Thread(() -> { new Call().whatsAppCall();}).start();
        new Thread(() -> { new Call().mobileCall();}).start();
   }
}

class Call {

    //кодом, который идет после метода lock(), может воспользоватся только 1 поток
    //Lock - interface, это его реализация - ReentrantLock
    //lock.unlock(); нужно писать в finally

    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        System.out.println("Mobile call starts");
        try {
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        System.out.println("Skype call starts");
        try {
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void whatsAppCall() {
        lock.lock();
        System.out.println("WhatsApp call starts");
        try {
            Thread.sleep(7000);
            System.out.println("WhatsApp call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}