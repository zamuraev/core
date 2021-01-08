package multithreading;

import java.util.concurrent.CountDownLatch;

//условия чтобы потоки могли стартануть, обратный счетчик
//тут пример покупатели, котороые ждут пока откроект магазин
//чтобы магазин открылся нужно чтобы были выполнены условия в методе letsStart(), при этом счетчик  countDownLatch был равен 0

public class SyncCountDownLatchEx {

    static CountDownLatch countDownLatch = new CountDownLatch(3); //обратный отчет начнется с 3

    public static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown(); //уменьшим счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount()); //получаем значение счетчика

    }

    public static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown(); //уменьшим счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount()); //получаем значение счетчика

    }

    public static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown(); //уменьшим счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount()); //получаем значение счетчика
    }

    public static void letsStart() throws InterruptedException {
        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
   }

    public static void main(String[] args) throws InterruptedException {

        new Friend("Sergey", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Viktor", countDownLatch);
        new Friend("Marina", countDownLatch);
        letsStart();
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;
    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();   //при создании обьект Friend поток автоматически запускается
    }

    @Override
    public void run() {
        try {
            countDownLatch.await(); //если счетчик countDownLatch больше 0 - поток будет заблокрован пока счетчик не станет 0. Если счетчик уже 0 - поток будет безприпятственно выполнять работу
            System.out.println(name+ " приступил(а) к закупкам");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}