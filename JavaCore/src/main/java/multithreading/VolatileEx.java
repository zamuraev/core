package multithreading;

public class VolatileEx extends Thread {

    //volatile - за переменной потоки обращаются не к CPU-кэшу (кэш процессора), а к Main Memory
    //volatile использовать когда только один поток записывает значение, остальные читают. если записывают значение в переменную 2+ потока, используся другие техники
    volatile boolean b = true;
    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished. counter =" + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread = new VolatileEx();
        thread.start();
        Thread.sleep(3000); //sleep для потока main
        System.out.println("After 3 seconds it time to wake ");
        thread.b=false;
        thread.join();
        System.out.println("End of program");
    }
}
