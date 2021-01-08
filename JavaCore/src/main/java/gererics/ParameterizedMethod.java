package gererics;

import java.util.ArrayList;

public class ParameterizedMethod {

    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(10);
        al1.add(20);
        al1.add(30);
        int a = GetMethod.getSecondElement(al1);
        System.out.println(a);

        ArrayList<Double> al2 = new ArrayList<>();
        al2.add(3.4);
        al2.add(2.2);
        al2.add(5.5);
        Double str = GetMethod.getSecondElement(al2);
        System.out.println(str);
    }
}

class GetMethod {
    // <T> T,ArrayListEx1<T> - указываем тип place holder (тип возвращаемого значения)
    public static <T extends Number> T getSecondElement(ArrayList<T> al) {
        return al.get(1);
    }

}

