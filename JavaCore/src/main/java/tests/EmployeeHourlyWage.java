package tests;

public class EmployeeHourlyWage extends Employee {

    private double employeeHourlyRate;

    public EmployeeHourlyWage(int id, String name, double employeeHourlyRate) {
        super(id, name);
        this.employeeHourlyRate = employeeHourlyRate;
     }

    @Override
    protected double averageMonthlySalary() {
        this.averageMonthlySalary = this.employeeHourlyRate*20.8*8;
        return this.averageMonthlySalary;
       }

  }
