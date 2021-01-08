package collections.set_interface;

import org.w3c.dom.ls.LSOutput;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetEx2 {

    public static void main(String[] args) {

        //правило сравнения в Tree:
        //a.equals(b)-> true
        //a.compareTo(b)-> 0

        TreeSet<Student> treeSet = new TreeSet<>();
        Student st1 = new Student("Sergey", 5);
        Student st2 = new Student("Misha",  1);
        Student st3 = new Student("Igor",  2);
        Student st4 = new Student("Marina",  3);
        Student st5 = new Student("Olya",  4);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet);

        treeSet.first();   //получим первый элемент коллекции

        treeSet.last(); //последний элемент коллекции

        Student st6 = new Student("oleg",  2);
        Student st7 = new Student("Ivan", 4);
        treeSet.headSet(st6); //выведет элементы меньше, чем значение в параметре
        treeSet.tailSet(st6); //выведет элементы больше, чем значение в параметре
        //выведет элементы между двумя граничными значениями
        System.out.println(treeSet.subSet(st6, st7)); //>=st6 && < st7

        System.out.println(st3.equals(st6));
    }
}

class Student implements Comparable<Student> {

    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }


    // методах compareTo(), equals(), hashCode() при сравнении нужно использовать одинаковые поля класса

    @Override
    public int compareTo(Student another) {
        return this.course-another.course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
