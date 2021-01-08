package reflection_examples;

import java.lang.reflect.Field;

public class Ex3 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //рефлексия нарушает правила инкапсуляции
        Employee employee = new Employee(10, "Sergey", "IT");
        Class employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");
        //открываем себе доступ на работу с private полем
        field.setAccessible(true);
        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);

        field.set(employee, 1500);
        System.out.println(employee);

    }
}
