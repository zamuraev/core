package streams;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        List<Student> students = new ArrayList();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students = students.stream().filter(e ->
                e.getAge() > 22 && e.getAvgGrade()<7.2).collect(Collectors.toList());
        System.out.println(students);

        //создаем stream с 0
        Stream<Student> myStream = Stream.of(st1,st2,st3,st4,st5);
        students = myStream.filter(s -> s.getAge() >20).collect(Collectors.toList());
        System.out.println(students);

    }

}





