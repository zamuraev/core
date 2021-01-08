package tests;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Employee em1 = new EmployeeFixedPayment(1,"Sergey", 1200);
        Employee em2 = new EmployeeFixedPayment(2, "Zaur", 800);
        Employee em3 = new EmployeeFixedPayment(3, "Paul", 700);

        Employee em4 = new EmployeeHourlyWage(4, "Ivan", 8.0);
        Employee em5 = new EmployeeHourlyWage(5, "Mariya", 11.0);
        Employee em6 = new EmployeeHourlyWage(6, "Kolya", 10.5);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(em1);
        employeeList.add(em2);
        employeeList.add(em3);
        employeeList.add(em4);
        employeeList.add(em5);
        employeeList.add(em6);

        for (Employee employee : employeeList) {
            employee.averageMonthlySalary();
        }

        System.out.println("--------------------------");

        //sort Employee list by desc (averageMonthlySalary, name)
        employeeList.stream().sorted((emp1, emp2) -> {
         if (emp2.getAverageMonthlySalary() == emp1.getAverageMonthlySalary()) {
             return emp2.name.compareTo(emp1.getName());
         } else  {
             return (int) (emp2.getAverageMonthlySalary() - emp1.getAverageMonthlySalary());
         }
        }).forEach(System.out::println);
        System.out.println("--------------------------");

        //information about first 5 employees
        employeeList.stream().sorted((emp1, emp2) -> {
            if (emp2.getAverageMonthlySalary() == emp1.getAverageMonthlySalary()) {
                return emp2.name.compareTo(emp1.getName());
            } else  {
                return (int) (emp2.getAverageMonthlySalary() - emp1.getAverageMonthlySalary());
            }
        }).limit(5).forEach(System.out::println);
        System.out.println("--------------------------");

        //ID of 3 last employees from collection
        employeeList.stream().sorted((emp1, emp2) -> {
            if (emp1.getAverageMonthlySalary() == emp2.getAverageMonthlySalary()) {
                return emp1.name.compareTo(emp2.getName());
            } else  {
                return (int) (emp1.getAverageMonthlySalary() - emp2.getAverageMonthlySalary());
            }
        }).limit(3).map(e-> e.getId()).forEach(System.out::println);

        //serialization of Employee list into file "employee.bin"
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.bin")))
        {
            oos.writeObject(employeeList);
        }
        catch(IOException ex){

            ex.printStackTrace();
        }
        System.out.println("--------------------------");

        //read list of Employees from file "employee.bin"
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.bin")))
        {
            List<Employee> employees = (ArrayList) ois.readObject();
            System.out.println("File has been written");
            System.out.println(employees);
        }
        catch(IOException | ClassNotFoundException ex){

           ex.printStackTrace();
        }


    }
}
