package multithreading;

public class DeadLockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
        thread10.join();
        thread20.join();
    }

}

class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread10: попытка захватить монитор обьекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread10: Монитор обьекта lock1 захвачен");
            System.out.println("Thread10: попытка захватить монитор обьекта lock2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread10: Мониторы обьектов lock1 и lock2 захвачены");
            }
        }
    }
}

//чтобы избежать дедлока поток Thread20 должен захватывать мониторы в том же порядке, что и Thread10

class Thread20 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread20: попытка захватить монитор обьекта lock2");
        synchronized (DeadLockEx.lock2) {
            System.out.println("Thread20: Монитор обьекта lock2 захвачен");
            System.out.println("Thread20: попытка захватить монитор обьекта lock1");
            synchronized (DeadLockEx.lock1) {
                System.out.println("Thread20: Мониторы обьектов lock1 и lock2 захвачены");
            }
        }
    }
}