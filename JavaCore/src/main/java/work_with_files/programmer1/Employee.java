package work_with_files.programmer1;

import java.io.Serializable;

public class Employee implements Serializable { //отмечаем, что наш класс Employee теперь может сериализироватся

    private static long serialVersionUID =2;

    String name;
//    String surname;
    String department;
    int age;
    transient double salary;
    Car car;

    public Employee(String name,
//                    String surname,
                    String department,
                    int age,
                    double salary, Car car) {
        this.name = name;
//        this.surname = surname;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}