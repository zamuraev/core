package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {

    public static void main(String[] args) throws InterruptedException {

        //newScheduledThreadPool используем, когда хотим устанавливать рассписание для запуска наших потоков
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(1);
//        for (int i = 0; i<10; i++) {
//            scheduledExecutorSercice.execute(new RunnableImpl200());
//        }
        //schedule выполнит задачи через определенный период времени
//        scheduledExecutorService.schedule(new RunnableImpl200()
//        , 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

        //планирует переодическое выполнение задачи: начало выполнения - через 3 секунды, промежуток между началом выполнения 1 и стартом 2, началом выполнения 2 и стартом 3 задания - 1 секунда. если промежуток выполнения больше, не ждет - начинает 2 задачу сразу
//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl200(), 3, 1, TimeUnit.SECONDS);

        //scheduleWithFixedDelay тут уже между окончанием 1 и началом 2 задания должна пройти 1 секунда
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl200(), 3, 1, TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();

        //кэшированный threadPool - будет создавать в себе новые потоки по надобности
        //когда threads свободны - могут переиспользоватся, если threads не хватает - кэшированный thread пул создаст еще один thread
        //если задания не приходят = через 60 секунд удалит последний тред, будет новый наплыв заданий - будет создавать новые потоки
        ExecutorService executorService = Executors.newCachedThreadPool();


    }
}


class RunnableImpl200 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " begins work");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+ " ends work");
    }
}