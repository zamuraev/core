package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FactorialRunnable {

    //факториал натурального числа n - произведение всех чисел от 1 до n включительно
    // 5! = 1*2*3*4*5 =120

    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6);
        executorService.execute(factorial);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorialResult);

//      Future future = executorService.submit(factorial);
//      future.get(); //вернет 0 потому что run ничего не возвращает
       // future.isDone();

    }
}

class Factorial implements Runnable {
    int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public void run() {
        if (f <= 0) {
            System.out.println("Vi vveli nevernoe chislo");
            return;
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        FactorialRunnable.factorialResult = result;
    }
}