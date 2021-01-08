package collections.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//при поиске и сравнении hashMap и hashSet используют хэширование
//преобразования с помощью метода hashcode() любого обьекта в int
//поступает на вход обьект -> на выходе получаем int
//сравнение сначала идет по hashcode - потому что операция вычисления int будет гораздо быстрее, затем по equals
//нужно переопределять equals и hashcode у ключей
//если по equals обьекты равны, то и по hashCode у них также должен быть равным
//когда у разных обьектов один хэшкод - это называется колизией
//результат нескольких выполнений метода hashcode для одного и того же обьекта должен быть одинаковым
//если согласно методу equals обьекты не равны, то hashcode() у таких обьктов не обязательно должен быть разным

public class HashCodeEx1 {

    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();

        Student st1 = new Student("Sergey", "Zamuraev", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);

        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);

        Student st4 = new Student("Sergey", "Zamuraev", 3);
        boolean result = map.containsKey(st4);
        System.out.println("result = " + result);

        System.out.println(st1.hashCode());
        System.out.println(st4.hashCode());

        //capacity- by default 16, loadFactory - by default 0.75f (float)
        Map<Integer, Student> studentMap = new HashMap<>(16, 0.75f);



    }
}

final class Student implements Comparable<Student> {
   final String name;
   final String surname;
   final int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, course);
//    }

    @Override
    public int hashCode() {
        return name.length()*7 + surname.length()*11+course*53;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Student another) {
        return this.name.compareTo(another.name);
    }
}