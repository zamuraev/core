package streams;

import java.util.Arrays;

public class Test3 {

    public static void main(String[] args) {

        int[] array = {5, 9, 3, 8, 1};
        Arrays.stream(array).forEach(s -> {
            s*=2;
            System.out.println(s);});

        Arrays.stream(array).forEach(System.out::println);
        Arrays.stream(array).forEach(Utils::myMethod); //метод референс - каждый обьект коллекции (в потоке) мы добавляем в метод myMethod в качестве параметра класса Utils
                                //все равно что написать вот так forEach(el->Utils.myMethod(el))
    }
}

class Utils {

public static void myMethod(int a) {
    a+=5;
    System.out.println("Element =" + a);
}

}
