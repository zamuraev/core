package multithreading;

import java.util.concurrent.Executors;

public class Ex8 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        thread1.start();
        Ex8 thread2 = new Ex8();
        thread2.start();

        //поток main будет ждать окончания потоков thread1 и thread2 и только после этого продолжит свою работу
        thread1.join();
        thread2.join();

        System.out.println("The end!");



    }
}


class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}