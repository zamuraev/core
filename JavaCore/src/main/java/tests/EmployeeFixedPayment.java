package tests;

public class EmployeeFixedPayment extends Employee {

        public EmployeeFixedPayment(int id, String name, double averageMonthlySalary) {
        super(id, name);
        this.averageMonthlySalary = averageMonthlySalary;
    }

    @Override
    protected double averageMonthlySalary() {
        return averageMonthlySalary;
    }


}
