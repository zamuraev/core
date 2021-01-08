package comparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Sergey", "Zamuraev", 12345);
        list.add(emp1);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        list.add(emp2);
        Employee emp3 = new Employee(123, "Ivan", "Sidorov", 8542);
        list.add(emp3);
        System.out.println("Before sorting \n " + list);
        Collections.sort(list);
        System.out.println("After sorting \n " + list);

        //Arrays.sort()
        Arrays.sort(new Employee[] {emp1, emp2, emp3});
    }


    static class Employee implements Comparable<Employee> {

        Integer id;
        String name;
        String surname;
        int salary;

        public Employee(Integer id, String name, String surname, int salary) {
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
        public int compareTo(Employee anotherEmp) {
           //текущий обьект больше обьекта в параметре -> возвращаем положительное число
            // текущий обьект меньше обьекта в параметре -> возвращаем отрицательное число
            // обьекты равны -> возвращаем 0
            //первый вариант реализации
//            if(this.id == anotherEmp.id) {
//                return 0;
//            }
//            else if (this.id<anotherEmp.id) {
//                return -1;
//            }
//            else {
//                return 1;
//            }

            //второй вариант реализации -> в основном так пишут
            // return this.id - anotherEmp.id;

            //третий способ, при этом тип поля не примитвный тип данных, а обвертка
            //return this.id.compareTo(anotherEmp.id);

            //сравниваем по имени, если имена одинаковые - будем сравнивать по фамилии
            int res =  this.name.compareTo(anotherEmp.name);
            if (res==0) {
                res = this.surname.compareTo(anotherEmp.surname);
            }
            return res;
        }
    }
}
