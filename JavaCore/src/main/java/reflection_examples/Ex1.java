package reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //3 варианта создания
        //1
        Class employeeClass = Class.forName("reflection_examples.Employee");
//        //2
//        Class employeeClass2 = Employee.class;
//        //3
//        Employee emp = new Employee();
//        Class employeeClass3 = emp.getClass();

        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field =" + someField.getType());

        //получаем список полей нашего класса
        Field[] fields = employeeClass.getFields();
        for (Field field : fields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("===============");
        //получаем список приватных полей
        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("===============");
        //получаем доступ к методу
        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of " + someMethod1.getName() + " method: " + someMethod1.getReturnType() + ", parameter types:" + Arrays.toString(someMethod1.getParameterTypes()));
        System.out.println("===============");
        Method someMethod2 = employeeClass.getMethod("setSalary", double.class); //нужно указывать типы параметров иниче вылетет exeption
        System.out.println("Return type of " + someMethod2.getName() + " method: " + someMethod2.getReturnType() + ", parameter types:" + Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("===============");
        Method[] methods = employeeClass.getDeclaredMethods(); //getDeclaredMethods getMethods
        for (Method method : methods) {
            System.out.println("Return type of " + method.getName() + " method: " + method.getReturnType() + ", parameter types:" + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("===============");
        Method[] methods1 = employeeClass.getDeclaredMethods(); // хотим получить только private методы
        for (Method method : methods1) {
            if (Modifier.isPrivate(method.getModifiers())) {
                System.out.println("Return type of " + method.getName() + " method: " + method.getReturnType() + ", parameter types:" + Arrays.toString(method.getParameterTypes()));
            }
        }

        //получение конструктора [без параметров]
        Constructor constructor1 = employeeClass.getConstructor(); //получаем конструктор без параметров
        System.out.println("Constructor has " + constructor1.getParameterCount() + " parameters, their types are: " + Arrays.toString(constructor1.getParameterTypes()));
        //получение конструктора [3 параметра]
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class); //получаем конструктор с 3мя параметрами
        System.out.println("Constructor has " + constructor2.getParameterCount() + " parameters, their types are: " + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("**************");
        //получение списка конструкторов
        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor " + constructor.getName()+ " has " + constructor.getParameterCount() + " parameters, where their types are: " + Arrays.toString(constructor.getParameterTypes()));
        }
    }
}
