package multithreading;

public class WaitNotifyExample {

    public static void main(String[] args) throws InterruptedException {

        Market market = new Market(); //синхронизация 2х потоков будет по обьекту Market
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
/*методы wait и notify вызываются из синхронизированного блока кода, на обьете который используется для создания лока - т.е на мониторе (все равно что this.wait()), в данной задаче монитором будет выступать обьект Market
 *потоки producer и consumer будут синхронизированны по одному и тому же обьекту Market, поэтому они одновременно не могут работать с методом getBread и putBread
 * методом getBread будет пользоватся Consumer, уменьшает количество хлеба на 1 когда Consumer вызывает метод get,
 *  когда хлеба будет меньше 1 то поток  Consumer который вызывает этот метод будет ждать. Когда ждем - освобождаем монитор.
 * метод putBread которым пользуется поток Producer добавляет в магазин один хлеб и извещает поток Consumer методом notify что хлеб добавился и можешь его брать
 * если количество хлеба на витрине 5 тогда поток Producer больше не может производить хлеб и его поток будет ждать пока количество хлеба уменьшится
 * Consumer пользуется методом getBread, количество хлеба уменьшается на 1, метод notify уведомляет поток Producer что можно доложить 1 хлеб
 */

class Market {

    private int breadCount = 0;

    public synchronized void getBread() {

        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Количество хлеба в магазине" + breadCount);
        notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Количество хлеба в магазине" + breadCount);
        notify();
    }
}

class Producer implements Runnable {

    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {

    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            market.getBread();
        }
    }
}
