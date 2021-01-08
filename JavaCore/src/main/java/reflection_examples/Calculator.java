package reflection_examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {

    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Сумма: " + a + " и " + b + "=" + result);
    }

    void substraction(int a, int b) {
        int result = a - b;
        System.out.println("Разница: " + a + " и " + b + "=" + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Произведение: " + a + " и " + b + "=" + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("Частное: " + a + " и " + b + "=" + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("test100.txt")
        )) {
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;

            Method[] methods = cl.getDeclaredMethods();
            for (Method myMethod : methods) {
                if (myMethod.getName().equals(methodName)) {
                    method = myMethod;
                }
            }
            method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument)); //вызываем метод обьекта calculator, передаем ему 2 параметра

        } catch (IOException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
