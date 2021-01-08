package multithreading;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        R2 runnable = new R2();
       //синхронизация пойдет по runnable
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Counter2 {
    volatile static int count;
}

class MyRunnableImpl2 implements Runnable {

    private void doWork2() {
        System.out.println("Ura!!!");
    }
      public void doWork1() {
       //this - это обьект класса R2
          //мы синхнонизируемся на обьекте R2, только один поток за раз может заходить в этот синхронизированный блок кода
          //    doWork2() будет выполнятся параллельно, в блоке синхнонизиции - последовательно
          doWork2();
        synchronized (this) {
            Counter2.count++;
            System.out.println(Counter2.count);
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}



