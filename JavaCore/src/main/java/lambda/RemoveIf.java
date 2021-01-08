package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIf {

    //удалить элемент при помощи интерфейса Predicate
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        al.add("Privet");
        al.add("Poka");
        al.add("ok");
        al.add("Uchim Java");
        al.add("A imenno lambdas");
        System.out.println(al);

        al.removeIf(s -> s.length() > 5);

        Predicate<String> p = element -> element.length() > 5;
        al.removeIf(p);

        System.out.println(al);

    }
}
