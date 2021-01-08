package multithreading;

import java.sql.SQLOutput;

public class InterruptionEx {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        InrerruptedThread thread = new InrerruptedThread();
        thread.start();
        Thread.sleep(2000);
        //метод interrupt() посылает сигнал true в метод isInterrupted(), и прерывает поток;
        thread.interrupt();
        thread.join();
        System.out.println("main ends");
    }
}

class InrerruptedThread extends Thread {
    double sqrtSum = 0;

    @Override
    public void run() {
        for (int i = 1; i < 1_000_000_000; i++) {
            if (isInterrupted()) {
                System.out.println("Potok xotyat prervat");
                System.out.println("Mi ubedilis, chto sostoyanie vsex obyektov nornalnoe i reshili zavershit rabotu potoka");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                // метод isInterrupted подразумевает что поток останавливают во время работы. если поток в это время спит - следет выбросить exeption
                sleep(0);
            } catch (InterruptedException e) {
                System.out.println("Potok xotyat prervat vo vremya sna. Davayte zavershim rabotu");
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}