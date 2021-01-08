package multithreading;

public class Ex4 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" - "+"Privet");
        }).start();
    }

}
