package nested_classes.inner_class;

import org.w3c.dom.ls.LSOutput;

public class Car {

    String color;
    private int doorCount;
    Engine engine;

    public Car(String color, int doorCount) {

        Engine engine = new Engine(200);
        System.out.println(engine.horsePower);
        this.color = color;
        this.doorCount = doorCount;
        // this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }


    //inner класс всегда завязан на своем внешнем классе
    //если хотим создать обьект inner класса - нужно сначала создать обьект внешнего класса
    //может содержать только non-static элементы, но можно создать переменную константу
    //inner сlass может обращатся даже к private элементам внешнего класса
    //внешний класс может обращатся даже к private элементам inner класса, прежде создав его обьект
    //nested классы могут иметь свои nested классы
    class Engine {

        int horsePower;
        public final static int A = 5;


        public Engine(int horsePower) {
            this.horsePower = horsePower;
            System.out.println(doorCount);
        }

        @Override
        public String toString() {
            return "My Engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Car car1 = new Car("black", 4);
        Car.Engine engine1 = car1.new Engine(150);
        car1.setEngine(engine1);
        System.out.println(car1);
        System.out.println(engine1);
        Car.Engine engine2 = new Car("red", 2).new Engine(200);
        System.out.println(engine2);
    }

}