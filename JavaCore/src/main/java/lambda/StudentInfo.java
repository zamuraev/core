package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.List;

public class StudentInfo {

//Predicate - проверить на соответствие какому-либо условию
    void testStudents(List<Student> al, Predicate<Student> pr) {
        for(Student s: al) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }


//    void testStudents(List<Student> al, StudentChecks sc) {
//        for(Student s: al) {
//            if (sc.check(s)) {
//                System.out.println(s);
//            }
//        }
//    }

//
//    void printStudentsOverGrade(List<Student> al, double grade) {
//        for (Student s : al) {
//            if(s.avgGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//    void printStudentsUnderAge(List<Student> al, int age) {
//        for (Student s : al) {
//            if(s.age < age) {
//                System.out.println(s);
//            }
//        }
//    }
//    void printStudentsMixCondition(List<Student> al, int age, double grade, char sex) {
//        for (Student s : al) {
//            if(s.age > age && s.avgGrade < grade && s.sex==sex) {
//                System.out.println(s);
//            }
//        }
//    }
}

class Test {
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

        //Function -> загоняем обьект Student, на выхоже получаем Double из средних оценок студента
        Function<Student, Double> f = student -> student.avgGrade;
        System.out.println("++++++++++++++++++");
        double res = avgOfSmth(students, stud ->
            stud.avgGrade);
        System.out.println(res);
        System.out.println("++++++++++++++++++");
        double course = avgOfSmth(students, stud ->
                (double) stud.course);
        System.out.println(course);
    }

    private static double avgOfSmth (List<Student> list, Function <Student, Double> f){
        double result = 0;
        for (Student st : list) {
                result+=f.apply(st);
        }
        result = result/list.size();
        return result;
    }
}

//
//
//
//        Collections.sort(students, (s1, s2)-> {
//                return  s1.course-s2.course;
//            }
//        );
//        System.out.println(students);
//
//        StudentInfo info = new StudentInfo();
////        info.testStudents(students, new CheckOverGrade());
////        System.out.println("-----------------");
////        info.testStudents(students, new StudentChecks() {
////            @Override
////            public boolean check(Student s) {
////                return s.age<30;
////            }
////        });
//        System.out.println("-----------------");
//        info.testStudents(students, s -> {
//            return s.avgGrade>8;
//        });
//
////        StudentChecks sc = (Student p) -> {return p.avgGrade >8;};
////        info.testStudents(students, sc);
//
//        System.out.println("-----------------");
//        info.testStudents(students, s -> {
//            return s.age<30;
//        });
//        System.out.println("-----------------");
//        info.testStudents(students, s -> {
//            return s.sex=='f' && s.age>20 && s.avgGrade<9.5;
//        });
//
//        //для удаления студента по условию создаем Predicate
//        //метод and() помогает обьеденить 2 проверки
//        //метод or - вывести результат, если студенты проходят хотя бы по одной проверке
//        //отрицание проверки - метод negate()
//        Predicate<Student> p1 = p -> p.sex =='f';
//        Predicate<Student> p2 = p -> p.avgGrade > 7.5;
//        info.testStudents(students, p1);
//        info.testStudents(students, p2);
//        info.testStudents(students, p1.and(p2));
//        info.testStudents(students, p1.or(p2));
//        students.removeIf(p1.and(p2));
//
////        info.printStudentsOverGrade(students, 8);
////        System.out.println("-----------------");
////        info.printStudentsUnderAge(students, 30);
////        System.out.println("-----------------");
////        info.printStudentsMixCondition(students, 20, 9.5, 'f');
//        System.out.println("-----------------");



//@FunctionalInterface //содержит только 1 абстрактный метод
//interface StudentChecks {
//    boolean check(Student s);
//}
//
//
//class CheckOverGrade implements StudentChecks {
//    @Override
//    public boolean check(Student s) {
//        return s.avgGrade > 8;
//    }
//}
