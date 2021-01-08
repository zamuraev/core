package multithreading;

//приоритет потока
public class Ex5 {

    public static void main(String[] args) {
        MyThread5 thread5 = new MyThread5();
        thread5.setName("moy_potok");
        thread5.setPriority(9);
        thread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of myThread5 = " + thread5.getName() + " Priority of myThread5 = " + thread5.getPriority());
    }
}


class MyThread5 extends Thread {
    @Override
    public void run() {
        System.out.println("privet");
    }
}