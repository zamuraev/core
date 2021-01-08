package nested_classes.static_nested_class;

import org.w3c.dom.ls.LSOutput;

public class Car {

    String color;
    int doorCount;
    Engine engine;
    static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    void method() {
        //к статической переменной вложенно стат класса можно обращатся напрямую
        System.out.println(Engine.countOfObjects);
        //к не статической нужно обращатся только после создания экземпляра этого класса
        Engine e = new Engine(200);
        System.out.println(e.horsePower);
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

     //static class мы можем использовать как обычный класс, он не привязан к внешнему классу
    //может содержать static и non static элементы
    //из статического класса мы можем обращатся только к статическим переменным внешнего класса
    //внешний класс может обращатся даже к private элементам статического вложенного класса
    public static class Engine {

        int horsePower;
        private static int countOfObjects;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
            countOfObjects++;
            System.out.println(a);
        }



        @Override
        public String toString() {
            return "My Engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }


    class Z extends Car.Engine {

        public Z(int horsePower) {
            super(horsePower);
        }
    }

}

class Test {

    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);

        Car car = new Car("red", 2, engine);
        System.out.println(car);

        //так писать недопускается
        //Car.Engine engine2 = new car.Engine(150);

    }

}