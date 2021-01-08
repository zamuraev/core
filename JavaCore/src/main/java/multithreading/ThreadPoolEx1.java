package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {

    public static void main(String[] args) throws InterruptedException {

       // ExecutorService - это интерфейс, threadPoolExecutor - это его реализация
       // ExecutorService executorService = Executors.newSingleThreadExecutor(); //в таком threadPoll будет содержатся всего 1 поток, задачи будут выполнятся поочередно
        ExecutorService executorService = Executors.newFixedThreadPool(5); //factory method, создаем threadPool ни с помощью конструктора, а с помощью метода
        for (int i = 0; i<10; i++) {
                executorService.execute(new RunnableImpl100());
        }
        executorService.shutdown(); // останавливаем работу executorService
        executorService.awaitTermination(5, TimeUnit.SECONDS); //работает как метод join. ждет пока executorService закончит свою работу, либо пока не пройдет указанное время
        System.out.println("main ends");
    }
}

class RunnableImpl100 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


