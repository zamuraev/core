package multithreading;

import java.util.concurrent.*;

public class FactorialCallable {

    //факториал натурального числа n - произведение всех чисел от 1 до n включительно
    // 5! = 1*2*3*4*5 =120
    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(6);
        //для Callable вместо метода execute теперь будем использовать метод submit
        //результат что возвращает Callable хранится в методе Future
        Future<Integer> future = executorService.submit(factorial2);
        Integer factorialResult = null;
        try {
            //метод get() заблокирует поток, в котором он был вызван, до тех пор, пока обьект не будет найдет и Future не вернет наш результат
            System.out.println(future.isDone());
            factorialResult = future.get();
            System.out.println(future.isDone());
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
        // executorService.awaitTermination(10, TimeUnit.SECONDS);
        // awaitTermination будет не нужен, factorialResult уже будет хранить в себе значение
        System.out.println(factorialResult);
    }
}

class Factorial2 implements Callable<Integer> {
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Vi vveli nevernoe chislo");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }

    ;
}