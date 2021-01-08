package tests;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    protected int id;
    protected String name;
    protected double averageMonthlySalary;

       public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageMonthlySalary() {
        return averageMonthlySalary;
    }

    public void setAverageMonthlySalary(double averageMonthlySalary) {
        this.averageMonthlySalary = averageMonthlySalary;
    }

    protected abstract double averageMonthlySalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", averageMonthlySalary=" + averageMonthlySalary +
                '}';
    }
}