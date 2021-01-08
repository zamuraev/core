package reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class employeeClass = Class.forName("reflection_examples.Employee");

        //как было раньше
        Employee o = (Employee) employeeClass.newInstance();
        System.out.println(o);

        //Работа с конструкторами
        //как лучше всего делать сейчас -> используем конструктор без параметров
        Constructor<Employee> constructor = employeeClass.getConstructor();
        Object obj1 = constructor.newInstance();

        //конструктор с 3я параметрами
        Constructor<Employee> constructor1 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj2 = constructor1.newInstance(5, "Sergey", "Java");
        System.out.println(obj2);

        //вызываем метод при помощи рефлексии
        Method method = employeeClass.getMethod("setSalary", double.class);
        //запускаем этот метод -> т.е метод запускаем на обьекте obj2 c аргументом 800.88
        method.invoke(obj2, 800.88);
        System.out.println(obj2);

    }
}
