package comparation;

import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        List<Employee2> list = new ArrayList<>();
        Employee2 emp1 = new Employee2(100, "Sergey", "Zamuraev", 12345);
        list.add(emp1);
        Employee2 emp2 = new Employee2(15, "Ivan", "Petrov", 6542);
        list.add(emp2);
        Employee2 emp3 = new Employee2(123, "Ivan", "Sidorov", 8542);
        list.add(emp3);
        System.out.println("Before sorting \n " + list);
        //в метод sort() в качестве 2го параметра передаем NameComparator
        //по умолчанию будет работать IdComparator. при добавлении 2го параметра будет работать новый компаратор SalaryComparator
        //Collections.sort(list);
        Collections.sort(list, new SalaryComparator());
        System.out.println("After sorting \n " + list);

        //Arrays.sort()
        //Arrays.sort(new Employee2[] {emp1, emp2, emp3});
    }

    static class Employee2 implements Comparable<Employee2>{

        Integer id;
        String name;
        String surname;
        int salary;

        public Employee2(Integer id, String name, String surname, int salary) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee {" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public int compareTo(Employee2 emp) {
            return this.id.compareTo(emp.id);
        }
    }

    //Comparator - используется если нет доступа к классу, Comparable - если есть доступ к классу
      static class SalaryComparator implements Comparator<Employee2> {
        @Override
        public int compare(Employee2 emp1, Employee2 emp2) {
            return emp1.salary - emp2.salary;
        }
    }

    static class NameComparator implements Comparator<Employee2> {
        @Override
        public int compare(Employee2 emp1, Employee2 emp2) {
            int res =  emp1.name.compareTo(emp2.name);
            if (res==0) {
                res = emp1.surname.compareTo(emp2.surname);
            }
            return res;
        }
    }

}


