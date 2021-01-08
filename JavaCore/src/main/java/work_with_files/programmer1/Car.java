package work_with_files.programmer1;

import java.io.Serializable;

public class Car implements Serializable { //клас Car также должен имплементировать Serializable

    String model;
    String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}