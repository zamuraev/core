package gererics;

public class ParameterizedClass {

    public static void main(String[] args) {
        //вписываем тип данных который заменит тип данных переменной T
//        Info<Double> info1 = new Info<>(3.14);
//        System.out.println(info1);
//        Double s = info1.getValue();
//
//        Info<Integer> info2 = new Info<>(4);
//        System.out.println(info2);
//        Integer n = info2.getValue();
    }

    //overload type erasure -> для jvm оба метода выглядят одинаково - как "abc(Info info)"
//    public void abc(Info<String> info) {
//        String s = info.getValue();
//        }
//    public void abc(Info<Integer> info) {
//        Integer i = info.getValue();
//    }



}

//сам Number и его наследники, + имплементят интерфейсы I1 и I2 "T extends Number&I1&I2"
class Info<T> {
    //T - type place holder
    //E - element
    //K - key
    //V - value

    //не может быть статичной (общей для всех обьектов)
    private T value;

    public Info(T value) {
        this.value = value;
    }
    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}

interface I1 {

}
interface I2 {

}

//overriding type erasure -> не дает сделать компилятор потому что при кастинге в subclass будет возникать erasure
//class Parent {
//    public void abc(Info<String> info) {
//        String s = info.getValue();
//    }
//}
//
//class ChildParent extends Parent {
//    public void abc(Info<Integer> info) {
//        String s = info.getValue();
//    }
//}