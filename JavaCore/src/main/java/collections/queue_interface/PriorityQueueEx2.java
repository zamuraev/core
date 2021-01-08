package collections.queue_interface;

import org.w3c.dom.ls.LSOutput;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQueueEx2 {

    public static void main(String[] args) {

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        Student st1 = new Student("Sergey", 5);
        Student st2 = new Student("Misha",  1);
        Student st3 = new Student("Igor",  2);
        Student st4 = new Student("Marina",  3);
        Student st5 = new Student("Olya",  4);

        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        priorityQueue.add(st5);

        System.out.println(priorityQueue.poll()); //выведем на экран и удалим 5 верхних элементов коллекции
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue);

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
