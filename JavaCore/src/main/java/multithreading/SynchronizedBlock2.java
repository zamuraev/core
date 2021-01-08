package multithreading;

public class SynchronizedBlock2 {
    volatile static int counter = 0;
    public static void increment() {
        //метод статический - поэтому нужно синхнонизировать блок на всем классе
        synchronized (SynchronizedBlock2.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter); //main поток ждет пока выполнится поток thread1 и thread2, и только затем выводит значение counter
    }
}

class R2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Ex11.increment();
        }
    }
}



