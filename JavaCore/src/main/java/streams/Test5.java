package streams;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));


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
        System.out.println("==========================");
        List<Student> students1 = students.stream().sorted((s1, s2) -> {return s1.getAge() - s2.getAge();}).collect(Collectors.toList());
        List<Student> students2 = students.stream().sorted((s1, s2) -> {return s1.getName().compareTo(s2.getName());}).collect(Collectors.toList());
        System.out.println(students1);
        System.out.println(students2);

        //.фильтруем filter-> изменяем значение map -> получаем сумму всех элементов reduce -> получаем элемент на выходе
       int result =  Arrays.stream(array).filter(v -> v%2==1).map(e->{if (e%3==0) {e=e/3;} return e;}).reduce((a,e)-> a+e).getAsInt();
        System.out.println(result);
        System.out.println("==========================");
        //сделать все имена с заглавной буквы -> оставить только женский пол -> отсортировать по возрасту
//       students.stream().map(element -> {
//            element.setName(element.getName().toUpperCase());
//            return element;
//        }).filter(element-> element.getSex()=='f').sorted((o1, o2) -> {return o1.getAge()-o2.getAge();}).forEach(System.out::println);

           //findFirst - получим только 1 элемент а не всю коллецию
        Student student = students.stream().map(element -> {
            element.setName(element.getName().toUpperCase());
            return element;
        }).filter(element-> element.getSex()=='f').sorted((o1, o2) -> {return o1.getAge()-o2.getAge();}).findFirst().get();
        System.out.println(student);


    }
}
