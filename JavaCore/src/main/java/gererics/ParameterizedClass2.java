package gererics;

public class ParameterizedClass2 {

    public static void main(String[] args) {
        Pair<String> pair1 = new Pair<>("Hello", "MyFriend");
        Pair<Integer> pair2 = new Pair<>(3, 2);
        System.out.println(pair1);
        System.out.println(pair2);
    }
}

class Pair<V> {

    private V value1;
    private V value2;

    //если метод обьявлен в параметризированном классе то <V> можно не указывать
    public V abc(V val)  {
        return val;
    }

    public Pair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}