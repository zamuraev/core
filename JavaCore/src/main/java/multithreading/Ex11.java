package multithreading;

public class Ex11 {

    volatile static int counter = 0;
    //нужно синхронизировать метод, чтобы в него мог заходить только одик поток за раз
        public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter); //main поток ждет пока выполнится поток thread1 и thread2, и только затем выводит значение counter
    }
}

class R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
                Ex11.increment();
        }
    }
}
